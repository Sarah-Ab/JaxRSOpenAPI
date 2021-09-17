package fr.istic.taa.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.istic.taa.jaxrs.rest.AppointmentResource;
import fr.istic.taa.jaxrs.rest.SwaggerResource;
import fr.istic.taa.jaxrs.rest.UserResource;
import fr.istic.taa.jaxrs.rest.WorkerResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

@ApplicationPath("/")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<>();

		// Swagger endpoints
		resources.add(OpenApiResource.class);

		// Your own resources
		resources.add(AppointmentResource.class);
		resources.add(UserResource.class);
		resources.add(WorkerResource.class);

		// Swagger resource
		resources.add(SwaggerResource.class);

		return resources;
	}

}
