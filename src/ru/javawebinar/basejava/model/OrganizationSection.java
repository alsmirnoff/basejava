package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {

    private static final long serialVersionUID = 1L;

    private List<Organization> organizations;

    public OrganizationSection() {}

    public OrganizationSection(Organization... organizations) { 
        this(Arrays.asList(organizations)); 
    }

    public OrganizationSection(List<Organization> organizations){
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() { 
        return organizations.toString(); 
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OrganizationSection other = (OrganizationSection) obj;
        return organizations.equals(other.organizations); 
    }

}
