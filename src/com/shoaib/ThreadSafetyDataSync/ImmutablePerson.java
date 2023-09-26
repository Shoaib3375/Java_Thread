package com.shoaib.ThreadSafetyDataSync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutablePerson {
    private final String name;
    private final int age;
    private final List<String> friends;
    public ImmutablePerson(String name, int age,List<String> friends){
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>(friends);
    }

    public  String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public List<String> getFriends() {
        return Collections.unmodifiableList(this.friends);
    }
}
