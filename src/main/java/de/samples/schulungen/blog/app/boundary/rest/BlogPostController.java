package de.samples.schulungen.blog.app.boundary.rest;

import de.samples.schulungen.blog.app.domain.BlogPost;
import de.samples.schulungen.blog.app.domain.BlogPostService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/blogposts")
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostController {

  // JAX-RS
  // RestAssured
  private final BlogPostService service;
  private final BlogPostDtoMapper mapper;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<BlogPostDto> findAllBlogPosts() {
    return service
      .findAll()
      .map(mapper::map)
      .collect(Collectors.toList());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createBlogPost(
    @Valid BlogPostDto newPostDto,
    @Context UriInfo info
  ) {
    BlogPost newPost = mapper.map(newPostDto);
    service.add(newPost);
    BlogPostDto result = mapper.map(newPost);
    URI location = info
      .getAbsolutePathBuilder()
      .path(newPost.getId().toString())
      .build();
    return Response
      .created(location)
      .entity(result)
      .build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public BlogPostDto findById(@PathParam("id") UUID id) {
    return service
      .findById(id)
      .map(mapper::map)
      .orElseThrow(NotFoundException::new);
  }

}
