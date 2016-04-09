package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class CourseTree
{
    private List<Node> finalCourses, nodes;
    
    public CourseTree(List<Course> finalCourses)
    {
        nodes = new ArrayList<Node>();
        this.finalCourses = new ArrayList<Node>();
        for (Course finalCourse : finalCourses)
        {
            this.finalCourses.add(new Node(finalCourse));
        }
    }
    
    public class Node
    {
        final public Course     course;
        final public List<Node> prerequisites;
                                
        public Node(Course course)
        {
            prerequisites = new ArrayList<Node>();
            this.course = course;
            
            for (Course prerequisite : course.prerequisites)
            {
                boolean exists = false;
                for (Node node : nodes)
                {
                    if (node.course.name.equals(prerequisite.name))
                    {
                        prerequisites.add(node);
                        exists = true;
                        break;
                    }
                }
                if (!exists)
                {
                    prerequisites.add(new Node(prerequisite));
                }
            }
            nodes.add(this);
        }
    }
}
