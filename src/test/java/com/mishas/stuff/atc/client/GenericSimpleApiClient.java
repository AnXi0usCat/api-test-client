package com.mishas.stuff.atc.client;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.mishas.stuff.common.web.INameableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericSimpleApiClient<T extends INameableDto> {

    private final static String JSON = MediaType.APPLICATION_JSON.toString();

    @Autowired
    protected AtcPaths paths;

    private final Class<T> clazz;

    public GenericSimpleApiClient(Class<T> clazz) {
        this.clazz = clazz;
    }

    // API

    // find - one

    public final T findOne(final long id) {
        final Response response = findOneAsResponse(id);
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("findOne operation status was not 200");
        }
        return response.as(clazz);
    }

    public final Response findOneAsResponse(final long id) {
        return read(getUri() + "/" + id);
    }

    // create

    public final Response createAsResponse(final T resource) {
        return RestAssured.given().contentType(JSON).body(resource).post(getUri());
    }

    public final T create(final T resource) {
        final  Response response = createAsResponse(resource);
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("create operation status was not 200");
        }
        final String locationOfResourse = response.getHeader(HttpHeaders.LOCATION);
        return read(locationOfResourse).as(clazz);
    }

    // update

    public final Response updateAsResponse(final T resource) {
        return RestAssured.given().contentType(JSON).body(resource).put(getUri() + "/" + resource.getId());
    }

    public final T update(final T resource) {
        updateAsResponse(resource);
        return read(getUri() + "/" + resource.getId()).as(clazz);
    }

    // delete

    public final Response deleteAsResponse(final T resource) {
        return RestAssured.given().contentType(JSON).body(resource).delete(getUri() + "/" + resource.getId());
    }

    // API - other

    public abstract String getUri();

    public final Response read(String uri) {
        return RestAssured.given().accept(ContentType.JSON).get(uri);
    }
}
