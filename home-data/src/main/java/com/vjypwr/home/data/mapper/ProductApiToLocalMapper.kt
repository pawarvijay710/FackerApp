package com.vjypwr.home.data.mapper

import com.vjypwr.home.data.model.response.product.ProductData
import com.vjypwr.home.data.model.response.product.ProductImage
import com.vjypwr.home.data.model.response.product.ProductResponse
import com.vjypwr.home.domain.model.response.product.ProductDataLocal
import com.vjypwr.home.domain.model.response.product.ProductImageLocal
import com.vjypwr.home.domain.model.response.product.ProductLocalResponse
import javax.inject.Inject

class ProductApiToLocalMapper @Inject constructor() {

    fun toLocal(apiResponse: ProductResponse): ProductLocalResponse {
        return ProductLocalResponse(
            apiResponse.code,
            getData(apiResponse.data), apiResponse.status, apiResponse.total
        )
    }

    private fun getData(dataList: List<ProductData>?): List<ProductDataLocal>? {
        val list = mutableListOf<ProductDataLocal>()
        if (dataList != null) {
            for (data in dataList) {
                val localData = ProductDataLocal(
                    data.categories,
                    data.description,
                    data.ean,
                    data.id,
                    data.image,
                    getImages(data.images),
                    data.name,
                    data.netPrice,
                    data.price,
                    data.tags,
                    data.taxes,
                    data.upc
                )

                list.add(localData)
            }
        }
        return list
    }

    private fun getImages(images: List<ProductImage>?): List<ProductImageLocal>? {
        val list = mutableListOf<ProductImageLocal>()
        if (images != null) {
            for (image in images) {
                val localImage = ProductImageLocal(
                    image.description,
                    image.title,
                    image.url
                )

                list.add(localImage)
            }
        }
        return list
    }
}