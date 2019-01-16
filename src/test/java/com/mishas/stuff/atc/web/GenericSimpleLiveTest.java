package com.mishas.stuff.atc.web;

import com.jayway.restassured.response.Response;
import com.mishas.stuff.atc.client.GenericSimpleApiClient;
import com.mishas.stuff.common.web.IDto;
import com.mishas.stuff.common.web.INameableDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class GenericSimpleLiveTest<T extends INameableDto> {

    private final static String JSON = MediaType.APPLICATION_JSON.toString();

    private GenericSimpleApiClient<T> api;

    // API

    // find - one

    @Test
    public final void givenResourceExistedAndWasDeleted_whenRetrievingResource_then404IsReceived() {
        // given
        final T createdResource = getApi().create(createNewResource());
        getApi().deleteAsResponse(createdResource);

        // when
        final Response response = getApi().findOneAsResponse(createdResource.getId());

        // then
        assertTrue("When the NON existing resource was queries the response code was not404", response.getStatusCode() == 404);
    }

    // create

    @Test
    public void whenResourceIsCreated_then201IsReceived() {
        // when
        Response response = getApi().createAsResponse(createNewResource());

        // then
        assertTrue("Status code was not 201 when the new resource was created", response.getStatusCode() == 201);

    }

    @Test
    public final void givenResourceHasNameWithSpace_whenResourceIsCreated_then201IsReceived() {
        // given
        final T newResource = createNewResource();
        newResource.setName(randomAlphabetic(5) + " " + randomAlphabetic(5));

        // when
        Response response = getApi().createAsResponse(newResource);

        // then
        assertTrue("Status code was not 201 when the new resource was created", response.getStatusCode() == 201);
    }

    @Test
    public final void whenResourceIsCreatedWithNewAssociation_then409IsReceived() {
        // given
        final T newResource = createNewResource();
        getAssociations(newResource).add(createNewAssociationResource());

        // when
        Response response = getApi().createAsResponse(newResource);

        // then
        assertTrue("Status code was not 409 when the new resource with a new association was created", response.getStatusCode() == 409);
    }

    @Test
    public final void whenResourceIsCreatedWithInvalidAssociation_then409IsReceived() {
        // given
        final T newResource = createNewResource();
        final T newAssociation = createNewAssociationResource();
        newAssociation.setName(null);
        getAssociations(newResource).add(newAssociation);

        // when
        Response response = getApi().createAsResponse(newResource);

        // then
        assertTrue("Status code was not 409 when the new resource with a invalid association was created", response.getStatusCode() == 409);
    }

    @Test
    public final void whenResourceWithUnsupportedMediaTypeIsCreated_then415IsReceived() {
        // when
        Response response = getApi().given().contentType("unknown").post(getUri());

        // then
        assertTrue("Status code was not 415 when the new resource with a invalid media type was created", response.getStatusCode() == 415);

    }

    @Test
    public final void whenResourceIsCreatedWithNonNullId_then409IsReceived() {
        // given
        final T newResource = createNewResource();
        newResource.setId(5l);

        // when
        final Response response =  getApi().createAsResponse(newResource);

        // then
        assertTrue("Status code was not 409 when the new resource with a non Null ID was created", response.getStatusCode() == 409);
    }

    @Test
    public final void whenResourceIsCreated_thenResponseContainsTheLocationHeader() {
        // given
        final T newResource = createNewResource();

        // when
        final Response response = getApi().createAsResponse(newResource);

        // then
        assertTrue("When a new resource was created the Location header was null", response.getHeader(HttpHeaders.LOCATION) != null);
    }

    @Test
    public final void givenResourceExsits_whenResourceWithSameAttributeIsCreated_then409IsReceived() {
        // given
        final T newResource = createNewResource();
        getApi().createAsResponse(newResource);

        // when
        final Response response = getApi().createAsResponse(newResource);

        // then
        assertTrue("Duplicate resource was created successfully", response.getStatusCode() == 409);
    }

    // update

    @Test
    public final void givenResourceExists_whenResourceIsUpdated_then200IsReceived() {
        // give
        final T createdResource = getApi().create(createNewResource());
        createdResource.setName("New Name");

        // when
        final Response response = getApi().updateAsResponse(createdResource);

        // then
        assertTrue("When the resource was updated the response code was not 200", response.getStatusCode() == 200);
    }

    @Test
    public final void givenInvalidResource_whenResourceIsUpdated_then400BadRequestIsReceived() {
        // give
        final T createdResource = getApi().create(createNewResource());
        createdResource.setName(null);

        // when
        final Response response = getApi().updateAsResponse(createdResource);

        // then
        assertTrue("When the resource was updated with invalid name the response code was not 400", response.getStatusCode() == 400);
    }

    @Test
    public final void whenResourceIsUpdatedWithNullId_then400IsReceived() {
        // give
        final T createdResource = getApi().create(createNewResource());
        createdResource.setId(null);

        // when
        final Response response = getApi().updateAsResponse(createdResource);

        // then
        assertTrue("When the resource was updated with invalid ID the response code was not 400", response.getStatusCode() == 400);
    }

    @Test
    public final void whenNullResourceIsUpdated_then400IsReceived() {
        // when
        final Response response = getApi().given().contentType(JSON).put(getUri() + "/" + randomAlphabetic(8));

        // then
        assertTrue("When the null resource was updated the response code was not 400", response.getStatusCode() == 400);
    }

    @Test
    public final void givenResourceDoesNotExist_whenResourceIsUpdated_then404IsReceived() {
        // when
        final Response response = getApi().updateAsResponse(createNewResource());

        // then
        assertTrue("When the non existing resource was updated the response code was not 404", response.getStatusCode() == 400);
    }

    // delete

    @Test
    public final void givenResourceExists_whenResourceIsDeleted_then204IsReceived() {
        // given
        final T createdResource = getApi().create(createNewResource());

        // when
        final Response response = getApi().deleteAsResponse(createdResource);

        // then
        assertTrue("When the  existing resource was deleted the response code was not 204", response.getStatusCode() == 204);
    }

    @Test
    public final void whenResourceIsDeletedByIncorrectNonNumericId_then400IsReceived() {
        // given
        final T createdResource = getApi().create(createNewResource());

        // when
        final Response response = getApi().given().contentType(JSON).body(createdResource).delete(getUri() + "/" + "non numeric ID");

        // then
        assertTrue("When the existing resource was deleted with incorrect non numeric ID the response code was not 400", response.getStatusCode() == 400);
    }

    @Test
    public final void givenResourceDoesNotExist_whenResourceIsDeleted_then404IsReceived() {
        // when
        final Response response = getApi().deleteAsResponse(createNewResource());

        // then
        assertTrue("When the NON existing resource was deleted the response code was not404", response.getStatusCode() == 404);
    }

    // Utils

    private final String getUri() {
        return getApi().getUri() + "/";
    }

    protected abstract GenericSimpleApiClient<T> getApi();

    protected abstract T createNewResource();

    protected abstract <A extends IDto> Collection<A> getAssociations(T resource);

    protected abstract <A extends IDto> A createNewAssociationResource();

    // Spring

    @Autowired
    public void setApi(GenericSimpleApiClient<T> api) {
        this.api = api;
    }
}
