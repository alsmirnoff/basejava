package ru.javawebinar.basejava.storage.serializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.Link;
import ru.javawebinar.basejava.model.ListSection;
import ru.javawebinar.basejava.model.Organization;
import ru.javawebinar.basejava.model.OrganizationSection;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.Section;
import ru.javawebinar.basejava.model.SectionType;
import ru.javawebinar.basejava.model.TextSection;
import ru.javawebinar.basejava.model.Organization.Position;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            
            // TODO implements sections
            Map<SectionType, Section> sections = resume.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                if(entry.getKey().name() == SectionType.PERSONAL.toString() || entry.getKey().name() == SectionType.OBJECTIVE.toString()) {
                    dos.writeUTF(entry.getValue().toString());
                }
                if(entry.getKey().name() == SectionType.ACHIEVEMENTS.toString() || entry.getKey().name() == SectionType.QUALIFICATIONS.toString()) {
                    List<String> items = ((ListSection) entry.getValue()).getItems();
                    dos.writeInt(items.size());
                    for (String item : items) {
                        dos.writeUTF(item);
                    }
                }
                if(entry.getKey().name() == SectionType.EXPERIENCE.toString() || entry.getKey().name() == SectionType.EDUCATION.toString()) {
                    List<Organization> organizations = ((OrganizationSection) entry.getValue()).getOrganizations();
                    dos.writeInt(organizations.size());
                    for (Organization organization : organizations) {
                        dos.writeUTF(organization.getHomePage().getName());
                        dos.writeUTF(organization.getHomePage().getUrl());
                        List<Position> positions = organization.getPositions();
                        dos.writeInt(positions.size());
                        for (Position position : positions) {
                            dos.writeUTF(position.getStartDate().toString());
                            dos.writeUTF(position.getEndDate().toString());
                            dos.writeUTF(position.getTitle());
                            dos.writeUTF(position.getDescription());
                        }
                    }
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for(int i = 0; i < size; i++){
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            // TODO implements sections
            int sectionsSize = dis.readInt();
            for (int i = 0; i < sectionsSize; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                if(sectionType == SectionType.PERSONAL || sectionType == SectionType.OBJECTIVE) {
                    resume.addSection(sectionType, new TextSection(dis.readUTF()));
                }
                if(sectionType == SectionType.ACHIEVEMENTS || sectionType == SectionType.QUALIFICATIONS) {
                    int listSize = dis.readInt();
                    List<String> items = new ArrayList<>();
                    for (int j = 0; j < listSize; j++) {
                        items.add(dis.readUTF());
                    }
                    resume.addSection(sectionType, new ListSection(items));
                }
                if(sectionType == SectionType.EXPERIENCE || sectionType == SectionType.EDUCATION) {
                    int organizationSize = dis.readInt();
                    List<Organization> organizations = new ArrayList<>();
                    for (int j = 0; j < organizationSize; j++) {
                        Link link = new Link(dis.readUTF(), dis.readUTF());
                        int positionSize = dis.readInt();
                        List<Position> positions = new ArrayList<>();
                        for (int k = 0; k < positionSize; k++) {
                            positions.add(new Position(LocalDate.parse(dis.readUTF()), LocalDate.parse(dis.readUTF()), dis.readUTF(), dis.readUTF()));
                        }
                        organizations.add(new Organization(link, positions));
                    }
                    resume.addSection(sectionType, new OrganizationSection(organizations));
                }
            }

            return resume;
        }
    }

}
