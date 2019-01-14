package com.mishas.stuff.atc.web;

import com.mishas.stuff.atc.client.GenericSimpleApiClient;
import com.mishas.stuff.common.web.IDto;
import com.mishas.stuff.common.web.INameableDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class GenericSimpleLiveTest<T extends INameableDto> {

    private final static String JSON = MediaType.APPLICATION_JSON.toString();

    private GenericSimpleApiClient<T> api;

    // API

    // find - one

    // create

    @Test
    public void whenResourceIsCreated_then201IsReceived() { }

    @Test
    public final void givenResourceHasNameWithSpace_whenResourceIsCreated_then201IsReceived() {}

    @Test
    public final void whenResourceIsCreatedWithNewAssociation_then409IsReceived() {}

    @Test
    public final void whenResourceIsCreatedWithInvalidAssociation_then409IsReceived() {}

    @Test
    public final void whenResourceWithUnsupportedMediaTypeIsCreated_then415IsReceived() {}

    @Test
    public final void whenResourceIsCreatedWithNonNullId_then409IsReceived() {}

    @Test
    public final void whenResourceIsCreated_thenResponseContainsTheLocationHeader() {}

    @Test
    public final void givenResourceExsits_whenResourceWithSameAttributeIsCreated_then409IsReceived() {}

    // update

    @Test
    public final void givenResourceExists_whenResourceIsUpdated_then200IsReceived() {}

    @Test
    public final void givenInvalidResource_whenResourceIsUpdated_then400BadRequestIsReceived() {}

    @Test
    public final void whenResourceIsUpdatedWithNullId_then400IsReceived() {}

    @Test
    public final void whenNullResourceIsUpdated_then400IsReceived() {}

    @Test
    public final void givenResourceDoesNotExist_whenResourceIsUpdated_then404IsReceived() {}

    // delete

    @Test
    public final void givenResourceExists_whenResourceIsDeleted_then204IsReceived() {}

    @Test
    public final void whenResourceIsDeletedByIncorrectNonNumericId_then400IsReceived() {}

    @Test
    public final void givenResourceDoesNotExist_whenResourceIsDeleted_then404IsReceived() {}

    @Test
    public final void givenResourceExistedAndWasDeleted_whenRetrievingResource_then404IsReceived() {}

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
