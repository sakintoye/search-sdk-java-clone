/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.implementation;

import com.azure.search.service.*;
import com.azure.search.service.models.SearchRequestOptions;
import com.azure.search.service.models.ServiceStatistics;
import com.google.common.base.Joiner;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureClient;
import com.microsoft.azure.AzureServiceClient;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.*;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Func1;

import java.io.IOException;
import java.util.UUID;

/**
 * Initializes a new instance of the SearchServiceClientImpl class.
 */
public class SearchServiceClientImpl extends AzureServiceClient implements SearchServiceClient {
    /**
     * The Retrofit service to perform REST calls.
     */
    private SearchServiceClientService service;
    /**
     * the {@link AzureClient} used for long running operations.
     */
    private AzureClient azureClient;

    /**
     * Gets the {@link AzureClient} used for long running operations.
     *
     * @return the azure client;
     */
    public AzureClient getAzureClient() {
        return this.azureClient;
    }

    /**
     * Client Api Version.
     */
    private String apiVersion;

    /**
     * Gets Client Api Version.
     *
     * @return the apiVersion value.
     */
    public String apiVersion() {
        return this.apiVersion;
    }

    /**
     * The name of the Azure Search service.
     */
    private String searchServiceName;

    /**
     * Gets The name of the Azure Search service.
     *
     * @return the searchServiceName value.
     */
    public String searchServiceName() {
        return this.searchServiceName;
    }

    /**
     * Sets The name of the Azure Search service.
     *
     * @param searchServiceName the searchServiceName value.
     * @return the service client itself
     */
    public SearchServiceClientImpl withSearchServiceName(String searchServiceName) {
        this.searchServiceName = searchServiceName;
        return this;
    }

    /**
     * The DNS suffix of the Azure Search service. The default is search.windows.net.
     */
    private String searchDnsSuffix;

    /**
     * Gets The DNS suffix of the Azure Search service. The default is search.windows.net.
     *
     * @return the searchDnsSuffix value.
     */
    public String searchDnsSuffix() {
        return this.searchDnsSuffix;
    }

    /**
     * Sets The DNS suffix of the Azure Search service. The default is search.windows.net.
     *
     * @param searchDnsSuffix the searchDnsSuffix value.
     * @return the service client itself
     */
    public SearchServiceClientImpl withSearchDnsSuffix(String searchDnsSuffix) {
        this.searchDnsSuffix = searchDnsSuffix;
        return this;
    }

    /**
     * The preferred language for the response.
     */
    private String acceptLanguage;

    /**
     * Gets The preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets The preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself
     */
    public SearchServiceClientImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /**
     * The retry timeout in seconds for Long Running Operations. Default value is 30.
     */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself
     */
    public SearchServiceClientImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /**
     * Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id
     * value is generated and included in each request. Default is true.
     */
    private boolean generateClientRequestId;

    /**
     * Gets Whether a unique x-ms-client-request-id should be generated. When set to true a unique
     * x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets Whether a unique x-ms-client-request-id should be generated. When set to true a unique
     * x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself
     */
    public SearchServiceClientImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * The DataSources object to access its operations.
     */
    private DataSources dataSources;

    /**
     * Gets the DataSources object to access its operations.
     *
     * @return the DataSources object.
     */
    public DataSources dataSources() {
        return this.dataSources;
    }

    /**
     * The Indexers object to access its operations.
     */
    private Indexers indexers;

    /**
     * Gets the Indexers object to access its operations.
     *
     * @return the Indexers object.
     */
    public Indexers indexers() {
        return this.indexers;
    }

    /**
     * The Skillsets object to access its operations.
     */
    private Skillsets skillsets;

    /**
     * Gets the Skillsets object to access its operations.
     *
     * @return the Skillsets object.
     */
    public Skillsets skillsets() {
        return this.skillsets;
    }

    /**
     * The SynonymMaps object to access its operations.
     */
    private SynonymMaps synonymMaps;

    /**
     * Gets the SynonymMaps object to access its operations.
     *
     * @return the SynonymMaps object.
     */
    public SynonymMaps synonymMaps() {
        return this.synonymMaps;
    }

    /**
     * The Indexes object to access its operations.
     */
    private Indexes indexes;

    /**
     * Gets the Indexes object to access its operations.
     *
     * @return the Indexes object.
     */
    public Indexes indexes() {
        return this.indexes;
    }

    /**
     * Initializes an instance of SearchServiceClient client.
     *
     * @param credentials the management credentials for Azure
     */
    public SearchServiceClientImpl(ServiceClientCredentials credentials) {
        this("https://{searchServiceName}.{searchDnsSuffix}", credentials);
    }

    /**
     * Initializes an instance of SearchServiceClient client.
     *
     * @param baseUrl     the base URL of the host
     * @param credentials the management credentials for Azure
     */
    public SearchServiceClientImpl(String baseUrl, ServiceClientCredentials credentials) {
        super(baseUrl, credentials);
        initialize();
    }

    /**
     * Initializes an instance of SearchServiceClient client.
     *
     * @param restClient the REST client to connect to Azure.
     */
    public SearchServiceClientImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    protected void initialize() {
        this.apiVersion = "2019-05-06";
        this.searchDnsSuffix = "search.windows.net";
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.dataSources = new DataSourcesImpl(restClient().retrofit(), this);
        this.indexers = new IndexersImpl(restClient().retrofit(), this);
        this.skillsets = new SkillsetsImpl(restClient().retrofit(), this);
        this.synonymMaps = new SynonymMapsImpl(restClient().retrofit(), this);
        this.indexes = new IndexesImpl(restClient().retrofit(), this);
        this.azureClient = new AzureClient(this);
        initializeService();
    }

    /**
     * Gets the User-Agent header for the client.
     *
     * @return the user agent string.
     */
    @Override
    public String userAgent() {
        return String.format("%s (%s, %s)", super.userAgent(), "SearchServiceClient", "2019-05-06");
    }

    private void initializeService() {
        service = restClient().retrofit().create(SearchServiceClientService.class);
    }

    /**
     * The interface defining all the services for SearchServiceClient to be
     * used by Retrofit to perform actually REST calls.
     */
    interface SearchServiceClientService {
        @Headers({"Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.azure.search.service" +
            ".SearchServiceClient getServiceStatistics"})
        @GET("servicestats")
        Observable<Response<ResponseBody>> getServiceStatistics(
            @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage,
            @Header("client-request-id") UUID clientRequestId,
            @Header("x-ms-parameterized-host") String parameterizedHost, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @return the ServiceStatistics object if successful.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException           thrown if the request is rejected by server
     * @throws RuntimeException         all other wrapped checked exceptions if the request fails to be sent
     */
    public ServiceStatistics getServiceStatistics() {
        return getServiceStatisticsWithServiceResponseAsync().toBlocking().single().body();
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceFuture} object
     * @throws IllegalArgumentException thrown if parameters fail the validation
     */
    public ServiceFuture<ServiceStatistics> getServiceStatisticsAsync(
        final ServiceCallback<ServiceStatistics> serviceCallback) {
        return ServiceFuture.fromResponse(getServiceStatisticsWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @return the observable to the ServiceStatistics object
     * @throws IllegalArgumentException thrown if parameters fail the validation
     */
    public Observable<ServiceStatistics> getServiceStatisticsAsync() {
        return getServiceStatisticsWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<ServiceStatistics>, ServiceStatistics>() {
                @Override
                public ServiceStatistics call(ServiceResponse<ServiceStatistics> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @return the observable to the ServiceStatistics object
     * @throws IllegalArgumentException thrown if parameters fail the validation
     */
    public Observable<ServiceResponse<ServiceStatistics>> getServiceStatisticsWithServiceResponseAsync() {
        if (this.searchServiceName() == null) {
            throw new IllegalArgumentException("Parameter client.searchServiceName() is required and cannot be null.");
        }
        if (this.searchDnsSuffix() == null) {
            throw new IllegalArgumentException("Parameter client.searchDnsSuffix() is required and cannot be null.");
        }
        if (this.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.apiVersion() is required and cannot be null.");
        }
        final SearchRequestOptions searchRequestOptions = null;
        UUID clientRequestId = null;
        String parameterizedHost = Joiner.on(", ")
            .join("{searchServiceName}", this.searchServiceName(), "{searchDnsSuffix}", this.searchDnsSuffix());
        return service
            .getServiceStatistics(this.apiVersion(), this.acceptLanguage(), clientRequestId, parameterizedHost,
                this.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ServiceStatistics>>>() {
                @Override
                public Observable<ServiceResponse<ServiceStatistics>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ServiceStatistics> clientResponse = getServiceStatisticsDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @param searchRequestOptions Additional parameters for the operation
     * @return the ServiceStatistics object if successful.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException           thrown if the request is rejected by server
     * @throws RuntimeException         all other wrapped checked exceptions if the request fails to be sent
     */
    public ServiceStatistics getServiceStatistics(SearchRequestOptions searchRequestOptions) {
        return getServiceStatisticsWithServiceResponseAsync(searchRequestOptions).toBlocking().single().body();
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @param searchRequestOptions Additional parameters for the operation
     * @param serviceCallback      the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceFuture} object
     * @throws IllegalArgumentException thrown if parameters fail the validation
     */
    public ServiceFuture<ServiceStatistics> getServiceStatisticsAsync(
        SearchRequestOptions searchRequestOptions, final ServiceCallback<ServiceStatistics> serviceCallback) {
        return ServiceFuture
            .fromResponse(getServiceStatisticsWithServiceResponseAsync(searchRequestOptions), serviceCallback);
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @param searchRequestOptions Additional parameters for the operation
     * @return the observable to the ServiceStatistics object
     * @throws IllegalArgumentException thrown if parameters fail the validation
     */
    public Observable<ServiceStatistics> getServiceStatisticsAsync(SearchRequestOptions searchRequestOptions) {
        return getServiceStatisticsWithServiceResponseAsync(searchRequestOptions)
            .map(new Func1<ServiceResponse<ServiceStatistics>, ServiceStatistics>() {
                @Override
                public ServiceStatistics call(ServiceResponse<ServiceStatistics> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets service level statistics for an Azure Search service.
     *
     * @param searchRequestOptions Additional parameters for the operation
     * @return the observable to the ServiceStatistics object
     * @throws IllegalArgumentException thrown if parameters fail the validation
     */
    public Observable<ServiceResponse<ServiceStatistics>> getServiceStatisticsWithServiceResponseAsync(
        SearchRequestOptions searchRequestOptions) {
        if (this.searchServiceName() == null) {
            throw new IllegalArgumentException("Parameter client.searchServiceName() is required and cannot be null.");
        }
        if (this.searchDnsSuffix() == null) {
            throw new IllegalArgumentException("Parameter client.searchDnsSuffix() is required and cannot be null.");
        }
        if (this.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.apiVersion() is required and cannot be null.");
        }
        Validator.validate(searchRequestOptions);
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.clientRequestId();
        }
        String parameterizedHost = Joiner.on(", ")
            .join("{searchServiceName}", this.searchServiceName(), "{searchDnsSuffix}", this.searchDnsSuffix());
        return service
            .getServiceStatistics(this.apiVersion(), this.acceptLanguage(), clientRequestId, parameterizedHost,
                this.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ServiceStatistics>>>() {
                @Override
                public Observable<ServiceResponse<ServiceStatistics>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ServiceStatistics> clientResponse = getServiceStatisticsDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ServiceStatistics> getServiceStatisticsDelegate(Response<ResponseBody> response)
        throws CloudException, IOException, IllegalArgumentException {
        return this.restClient().responseBuilderFactory().<ServiceStatistics, CloudException>newInstance(
            this.serializerAdapter())
            .register(200, new TypeToken<ServiceStatistics>() {
            }.getType())
            .registerError(CloudException.class)
            .build(response);
    }

}