package learn.spring.rest.services.util;

import java.util.ArrayList;
import java.util.List;

import learn.spring.rest.model.Blog;

public class BlogList {

    private List<Blog> blogs = new ArrayList<Blog>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
