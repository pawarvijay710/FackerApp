package com.vjypwr.home.presentation

import android.content.res.Resources
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.common.UseCaseExecutor
import com.example.domain.common.model.UseCaseResult
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.whenever
import com.vjypwr.home.domain.model.response.product.ProductLocalResponse
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import com.vjypwr.home.domain.usecase.BookUseCase
import com.vjypwr.home.domain.usecase.HighlightUseCase
import com.vjypwr.home.domain.usecase.ProductUseCase
import org.junit.Assert
import org.junit.Before
import org.mockito.Mock

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var resources: Resources

    @Mock
    private lateinit var useCaseExecutor: UseCaseExecutor

    @Mock
    private lateinit var productUseCase: ProductUseCase

    @Mock
    private lateinit var bookUseCase: BookUseCase

    @Mock
    private lateinit var highlightUseCase: HighlightUseCase

    private lateinit var classUnderTest: HomeViewModel

    @Before
    fun setup() {
        classUnderTest = HomeViewModel(
            useCaseExecutor,
            productUseCase, bookUseCase, highlightUseCase,
            resources
        )
    }

    @Test
    fun `test call to product API`() {
        val response = getProductResponse().data!!
        givenProductApiListUseCaseResult(UseCaseResult.Success(getProductResponse()))
        classUnderTest.callGetProductsApi(2)
        Assert.assertEquals(response, classUnderTest.productList.value)
    }

    private fun givenProductApiListUseCaseResult(result: UseCaseResult<ProductLocalResponse>) {
        doAnswer { invocationOnMock ->
            val callback =
                invocationOnMock.arguments[2] as (UseCaseResult<ProductLocalResponse>) -> Unit
            callback(result)
        }.whenever(
            useCaseExecutor
        ).execute(
            eq(productUseCase),
            any<Int>(),
            any<(UseCaseResult<ProductLocalResponse>) -> Unit>()
        )
    }

    private fun getProductResponse(): ProductLocalResponse {
        val responseStr = "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"code\": 200,\n" +
                "    \"total\": 2,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"Quas ipsam nobis iusto.\",\n" +
                "            \"description\": \"Occaecati nemo saepe error suscipit ducimus dolore porro quisquam. Est consequatur corrupti voluptate architecto et.\",\n" +
                "            \"ean\": \"9284629668129\",\n" +
                "            \"upc\": \"316741977529\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Architecto dolor id in.\",\n" +
                "                    \"description\": \"Molestiae sint nihil temporibus et facere fugiat quasi. Et dolores magni quisquam voluptas dolore. Asperiores quaerat assumenda et. Eius quia sunt sit ipsum accusamus.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Et ea est nostrum iure natus.\",\n" +
                "                    \"description\": \"Hic voluptas ut est officia qui quam et aperiam. Commodi possimus ab quia et est. Et et veritatis architecto aut molestiae nam rerum aspernatur. Eius vel non est quia iure.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Dolores omnis quis quas.\",\n" +
                "                    \"description\": \"Similique impedit placeat aliquam vel dolor iste. Ea est similique ratione possimus natus voluptatibus sit saepe. Et sapiente dolores ipsam expedita doloribus eius cum.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 25.06,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"27.57\",\n" +
                "            \"categories\": [\n" +
                "                \"aut\",\n" +
                "                \"provident\",\n" +
                "                \"sed\",\n" +
                "                \"sequi\",\n" +
                "                \"in\",\n" +
                "                \"autem\",\n" +
                "                \"est\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"mollitia\",\n" +
                "                \"quis\",\n" +
                "                \"tempora\",\n" +
                "                \"officiis\",\n" +
                "                \"eos\",\n" +
                "                \"officia\",\n" +
                "                \"odio\",\n" +
                "                \"eos\",\n" +
                "                \"dolor\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"Magnam soluta id aut non.\",\n" +
                "            \"description\": \"Atque non molestias adipisci sequi error. Aliquid doloremque id repellat et saepe provident quo. Nam dolorem delectus et qui aliquam in in.\",\n" +
                "            \"ean\": \"0555338606214\",\n" +
                "            \"upc\": \"522477428600\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Voluptatem nisi debitis et.\",\n" +
                "                    \"description\": \"Rerum dolores aut consequatur ducimus et magnam est. Quos quis aut et quo repellendus. Laborum voluptatem aut inventore nesciunt placeat aut commodi.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Aut et velit pariatur.\",\n" +
                "                    \"description\": \"Repudiandae incidunt et est maxime. Laudantium maxime facere dolores impedit doloribus. Omnis est cupiditate fugiat et voluptatem.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Quidem dolore quis culpa.\",\n" +
                "                    \"description\": \"Suscipit maiores dolor doloremque et. Tenetur mollitia deserunt in quis qui quos. Est harum itaque eligendi.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 0.01,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"0.01\",\n" +
                "            \"categories\": [\n" +
                "                \"eveniet\",\n" +
                "                \"officiis\",\n" +
                "                \"autem\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"commodi\",\n" +
                "                \"non\",\n" +
                "                \"rerum\",\n" +
                "                \"minus\",\n" +
                "                \"aut\",\n" +
                "                \"sint\",\n" +
                "                \"vel\",\n" +
                "                \"minima\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}"

        return Gson().fromJson(responseStr, ProductLocalResponse::class.java)
    }
}