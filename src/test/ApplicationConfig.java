package test;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resource = new java.util.HashSet<>();
		addRestResourceClasses(resource);
		return resource;
	}

	public void addRestResourceClasses(Set<Class<?>> resource) {
		resource.add(test.Api.class);
	}
}
