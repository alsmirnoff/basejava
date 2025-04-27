package ru.javawebinar.basejava;

import java.time.Month;
import java.util.UUID;

import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.ListSection;
import ru.javawebinar.basejava.model.Organization;
import ru.javawebinar.basejava.model.OrganizationSection;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.SectionType;
import ru.javawebinar.basejava.model.TextSection;

public class ResumeTestData {

    public Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.addContact(ContactType.PHONE, "11111");
        resume.addContact(ContactType.EMAIL, "mail1@ya.ru");

        resume.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        resume.addSection(SectionType.ACHIEVEMENTS, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        
        resume.addSection(SectionType.EXPERIENCE, 
        new OrganizationSection(
            new Organization("Organization11", "http://Organization11.ru",
                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2")
        )));

        resume.addSection(SectionType.EDUCATION, 
            new OrganizationSection(
                new Organization("Institute", "non-null",
                    new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "non-null"),
                    new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                new Organization("Organization12", "http://Organization12.ru"))
        );


        /*resume.addContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.addContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.addContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.addContact(ContactType.HOME_PAGE, "http://gkislin.ru/");*/

        /*List<String> achievments = new ArrayList<>();
        achievments.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievments.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников. ");
        */

        /*List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        */

        /*Organization expOrganization1 = new Organization(
            "Alcatel", 
            "http://www.alcatel.ru/", 
            LocalDate.of(1997,9,1), 
            LocalDate.of(2005,1,1), 
            "Инженер по аппаратному и программному тестированию", 
            "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        Organization expOrganization2 = new Organization(
            "Siemens AG", 
            "https://www.siemens.com/ru/ru/home.html", 
            LocalDate.of(2005,1,1), 
            LocalDate.of(2007,2,1), 
            "Разработчик ПО", 
            "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        List<Organization> expOrganizations = new ArrayList<>();
        expOrganizations.add(expOrganization1);
        expOrganizations.add(expOrganization2);
        */

        /*Organization edOrg1 = new Organization(
            "Заочная физико-техническая школа при МФТИ", 
            "https://mipt.ru/", 
            LocalDate.of(1984,9,1), 
            LocalDate.of(1987,6,1), 
            "Закончил с отличием", 
            "");
        Organization edOrg2 = new Organization(
            "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", 
            "http://www.ifmo.ru/",
            LocalDate.of(1987,9,1), 
            LocalDate.of(1993,7,1), 
            "Инженер (программист Fortran, C)", 
            "");
        edOrg2.setPeriod(
            LocalDate.of(1993,9,1), 
            LocalDate.of(1996,7,1), 
            "Аспирантура (программист С, С++)", 
            "");
        List<Organization> edOrganizations = new ArrayList<>();
        edOrganizations.add(edOrg1);
        edOrganizations.add(edOrg2);*/

        return resume;
    }

    public static void main(String[] args) {

        Resume resume = new ResumeTestData().createResume(UUID.randomUUID().toString(), "Григорий Кислин");

        //имя
        System.out.println(resume.getFullName());

        System.out.println(ContactType.PHONE.getType() + ": " + resume.getContact(ContactType.PHONE));
        System.out.println(ContactType.EMAIL.getType() + ": " + resume.getContact(ContactType.EMAIL));
        System.out.println(ContactType.SKYPE.getType() + ": " + resume.getContact(ContactType.SKYPE));
        System.out.println(ContactType.LINKEDIN.getType() + ": " + resume.getContact(ContactType.LINKEDIN));
        System.out.println(ContactType.GITHUB.getType() + ": " + resume.getContact(ContactType.GITHUB));
        System.out.println(ContactType.STACKOVERFLOW.getType() + ": " + resume.getContact(ContactType.STACKOVERFLOW));
        System.out.println(ContactType.HOME_PAGE.getType() + ": " + resume.getContact(ContactType.HOME_PAGE));
        
        //позиция
        System.out.println("Позиция: ");
        System.out.println(resume.getSection(SectionType.OBJECTIVE));

        //личные качества
        System.out.println("Личные качества: ");
        System.out.println(resume.getSection(SectionType.PERSONAL));

        //достижения
        System.out.println("Достижения: ");
        ListSection acv = (ListSection)resume.getSection(SectionType.ACHIEVEMENTS);

        for (String item : acv.getItems()) {
            System.out.println("* " + item);
        }

        //квалификация
        System.out.println("Квалификация: ");
        ListSection qual = (ListSection)resume.getSection(SectionType.QUALIFICATIONS);

        for (String item : qual.getItems()) {
            System.out.println("* " + item);
        }

        //опыт работы
        System.out.println("Опыт работы: ");
        OrganizationSection expOrg = (OrganizationSection)resume.getSection(SectionType.EXPERIENCE);

        for (Organization item : expOrg.getOrganizations()) {
            System.out.println("* " + item);
        }

        //образование
        System.out.println("Образование: ");
        OrganizationSection edOrg = (OrganizationSection)resume.getSection(SectionType.EDUCATION);

        for (Organization item : edOrg.getOrganizations()) {
            System.out.println("* " + item);
        }
    }
}
