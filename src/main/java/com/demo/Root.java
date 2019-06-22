package com.demo;

import com.demo.models.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Root
{
    @GET
    public Book getBook(@Valid @NotNull @QueryParam("id") Long id)
    {
        //Just build a dummy book to return
        Book book = new Book();
        book.setId(id);
        book.setAuthor("Jorge Cajas");
        book.setPages(100);

        return book;
    }


    @POST
    public Book createBook(@Valid Book book)
    {
        //Do somehing, save to DB and return the book with a new ID
        book.setId(20L);
        return book;
    }
}








