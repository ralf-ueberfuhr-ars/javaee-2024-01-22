package de.samples.schulungen.blog.app.domain;

import java.util.function.Supplier;

@FunctionalInterface
public interface BlogPostProvider extends Supplier<BlogPost> {

}
