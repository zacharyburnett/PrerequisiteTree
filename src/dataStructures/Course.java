package dataStructures;

import java.util.List;

public class Course
{
    final public String       name;
    final public List<Course> prerequisites;
                              
    public Course(String name, List<Course> prerequisites)
    {
        this.name = name;
        this.prerequisites = prerequisites;
    }
}
