package ru.javawebinar.basejava.reflectionexample;

import java.util.ArrayList;
import java.util.List;

public class SimpleClass {

    protected List<String> simpleList = new ArrayList<>();

    public List<String> getList(){
      return this.simpleList;
    }
  }