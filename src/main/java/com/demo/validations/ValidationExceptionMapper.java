package com.demo.validations;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Jorge on 14/05/2016.
 */

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException>
{
    private String getPropertyName(Path path)
    {
        //The path has the form of com.package.class.property
        //Split the path by the dot (.) and take the last segment.
        String[] split = path.toString().split("\\.");
        return split[split.length - 1];
    }

    @Override
    public Response toResponse(ConstraintViolationException exception)
    {
        Map<String, String> errors = exception.getConstraintViolations().stream()                                       //Get errors as Stream
                .collect(Collectors.toMap(v -> getPropertyName(v.getPropertyPath()), ConstraintViolation::getMessage)); //Collect them to a Map

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errors).type(MediaType.APPLICATION_JSON)
                .build();
    }
}