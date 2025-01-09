package ru.javawebinar.basejava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.ListSection;
import ru.javawebinar.basejava.model.Organization;
import ru.javawebinar.basejava.model.OrganizationSection;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.Section;
import ru.javawebinar.basejava.model.SectionType;
import ru.javawebinar.basejava.model.TextSection;

public class ResumeTestData {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String NAME_1 = "name1";
    private static final String NAME_2 = "name2";
    private static final String NAME_3 = "name3";
    private static final String NAME_4 = "name4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1, NAME_1);
        RESUME_2 = new Resume(UUID_2, NAME_2);
        RESUME_3 = new Resume(UUID_3, NAME_3);
        RESUME_4 = new Resume(UUID_4, NAME_4);
    }

    public Resume getResume(int i){
        switch (i) {
            case 1: return RESUME_1;
            case 2: return RESUME_2;
            case 3: return RESUME_3;
            case 4: return RESUME_4;
            default: return new Resume(null,null);}
    }



    public static void main(String[] args) {

        Resume resume = new Resume("Григорий Кислин");

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        contacts.put(ContactType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.SKYPE, "skype:grigory.kislin");
        contacts.put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.GITHUB, "https://github.com/gkislin");
        contacts.put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        contacts.put(ContactType.HOME_PAGE, "http://gkislin.ru/");

        
        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
        sections.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        sections.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям."));
        
        List<String> achievments = new ArrayList<>();
        achievments.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievments.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников. ");
        sections.put(SectionType.ACHIEVEMENTS, new ListSection(achievments));

        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        sections.put(SectionType.QUALIFICATIONS, new ListSection(qualifications));
        
        Organization expOrganization1 = new Organization("Alcatel", LocalDate.of(1997,9,1), LocalDate.of(2005,1,1));
        Organization expOrganization2 = new Organization("Siemens AG", LocalDate.of(2005,1,1), LocalDate.of(2007,2,1));
        List<Organization> expOrganizations = new ArrayList<>();
        expOrganizations.add(expOrganization1);
        expOrganizations.add(expOrganization2);
        sections.put(SectionType.EXPERIENCE, new OrganizationSection(expOrganizations));


        Organization edOrg1 = new Organization("Заочная физико-техническая школа при МФТИ", LocalDate.of(1984,9,1), LocalDate.of(1987,6,1));
        Organization edOrg2 = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", 
                            LocalDate.of(1987,9,1), LocalDate.of(1993,7,1));
        List<Organization> edOrganizations = new ArrayList<>();
        edOrganizations.add(edOrg1);
        edOrganizations.add(edOrg2);
        sections.put(SectionType.EDUCATION, new OrganizationSection(edOrganizations));

        resume.setContacts(contacts);
        resume.setSections(sections);

        //имя
        System.out.println(resume.getFullName());

        //контакты
        for (Map.Entry<ContactType, String> contact : resume.getContacts().entrySet()) {
            System.out.println(contact.getKey().getType() + ": " + contact.getValue());
        }

        //позиция
        System.out.println("Позиция: ");
        System.out.println(resume.getSections().get(SectionType.OBJECTIVE));

        //личные качества
        System.out.println("Личные качества: ");
        System.out.println(resume.getSections().get(SectionType.PERSONAL));

        //достижения
        System.out.println("Достижения: ");
        ListSection acv = (ListSection)resume.getSections().get(SectionType.ACHIEVEMENTS);

        for (String item : acv.getItems()) {
            System.out.println("* " + item);
        }

        //квалификация
        System.out.println("Квалификация: ");
        ListSection qual = (ListSection)resume.getSections().get(SectionType.QUALIFICATIONS);

        for (String item : qual.getItems()) {
            System.out.println("* " + item);
        }

        //опыт работы
        System.out.println("Опыт работы: ");
        OrganizationSection expOrg = (OrganizationSection)resume.getSections().get(SectionType.EXPERIENCE);

        for (Organization item : expOrg.getOrganizations()) {
            System.out.println("* " + item);
        }

        //образование
        System.out.println("Образование: ");
        OrganizationSection edOrg = (OrganizationSection)resume.getSections().get(SectionType.EDUCATION);

        for (Organization item : edOrg.getOrganizations()) {
            System.out.println("* " + item);
        }

    }
}
