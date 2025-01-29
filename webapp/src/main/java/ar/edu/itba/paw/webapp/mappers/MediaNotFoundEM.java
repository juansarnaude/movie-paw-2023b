package ar.edu.itba.paw.webapp.mappers;

import ar.edu.itba.paw.exceptions.MediaNotFoundException;
import ar.edu.itba.paw.webapp.dto.out.ResponseMessage;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Singleton
@Component
@Provider
public class MediaNotFoundEM implements ExceptionMapper<MediaNotFoundException> {
    @Override
    public Response toResponse(MediaNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ResponseMessage(exception.getMessage()))
                .build();
    }
}