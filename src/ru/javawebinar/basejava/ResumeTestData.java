package ru.javawebinar.basejava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.setContact(ContactType.HOME_PAGE, "http://gkislin.ru/");

        resume.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям."));

        List<String> achievments = new ArrayList<>();
        achievments.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievments.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников. ");
        resume.setSection(SectionType.ACHIEVEMENTS, new ListSection(achievments));

        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        resume.setSection(SectionType.QUALIFICATIONS, new ListSection(qualifications));

        Organization expOrganization1 = new Organization(
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
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(expOrganizations));

        Organization edOrg1 = new Organization(
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
        edOrganizations.add(edOrg2);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(edOrganizations));

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
