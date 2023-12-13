package com.vjypwr.home.data.mock

import com.google.gson.Gson
import com.vjypwr.home.data.model.response.product.ProductResponse

class MockProductResponse {
    fun getProductResponse(): ProductResponse {
        val responseStr = "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"code\": 200,\n" +
                "    \"total\": 5,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"Deserunt repellat quo rerum.\",\n" +
                "            \"description\": \"Harum qui esse nam dicta repellendus porro officia. Vero asperiores dolorem et voluptas nam quia. Non quia consectetur molestiae quasi et.\",\n" +
                "            \"ean\": \"3866738089253\",\n" +
                "            \"upc\": \"562796897409\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Dolor nisi illo ab quia.\",\n" +
                "                    \"description\": \"Vel quia aliquam aut et. Dolores at corrupti eius qui. Pariatur voluptate quia animi ipsam. Fugiat fugiat similique aut nihil placeat porro. Et error ipsa facilis.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Molestiae est enim ea et.\",\n" +
                "                    \"description\": \"Rerum ullam sed aliquam recusandae. Non est eum earum aliquam. Rerum laudantium veniam incidunt quidem. Commodi aut ratione vel voluptatem nihil.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Laborum qui qui quis aliquam.\",\n" +
                "                    \"description\": \"Deserunt molestias dolorem unde et eum sunt. Ad aut in non id quo. Facilis enim molestiae autem qui.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 9636.22,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"10599.84\",\n" +
                "            \"categories\": [\n" +
                "                \"consequatur\",\n" +
                "                \"est\",\n" +
                "                \"quam\",\n" +
                "                \"modi\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"facilis\",\n" +
                "                \"autem\",\n" +
                "                \"eum\",\n" +
                "                \"rerum\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"Ut qui saepe dicta possimus.\",\n" +
                "            \"description\": \"Inventore laboriosam sit quis vel accusantium ut. Rem et possimus impedit adipisci earum modi. Exercitationem incidunt tempore voluptas facilis ipsa.\",\n" +
                "            \"ean\": \"0681336839931\",\n" +
                "            \"upc\": \"071504537073\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Est et quis laboriosam enim.\",\n" +
                "                    \"description\": \"Voluptatem modi maxime deserunt excepturi. Maxime ipsam quasi in eaque placeat.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Qui quo eos excepturi.\",\n" +
                "                    \"description\": \"Omnis nobis doloremque est facilis. Enim repudiandae laboriosam maxime aliquam sunt id voluptas. Et sed quis dignissimos non nostrum in eligendi excepturi.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Autem aliquam id asperiores.\",\n" +
                "                    \"description\": \"Placeat non veniam et. Praesentium consequatur deleniti fuga aliquid quis ea voluptatem. Vitae nihil et reiciendis delectus sint sequi tempora.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 300192.29,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"330211.52\",\n" +
                "            \"categories\": [\n" +
                "                \"eveniet\",\n" +
                "                \"et\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"dicta\",\n" +
                "                \"officiis\",\n" +
                "                \"voluptas\",\n" +
                "                \"nulla\",\n" +
                "                \"tenetur\",\n" +
                "                \"assumenda\",\n" +
                "                \"ut\",\n" +
                "                \"numquam\",\n" +
                "                \"fugiat\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"name\": \"Et est eaque animi doloribus.\",\n" +
                "            \"description\": \"Neque fugit delectus omnis tempore et amet totam. Saepe est nostrum quisquam sint. Autem nemo enim itaque ipsam ullam et nihil. Repellat amet quis nesciunt autem similique. Tempora excepturi quam ea.\",\n" +
                "            \"ean\": \"7598686169980\",\n" +
                "            \"upc\": \"612340555241\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Reiciendis et neque et autem.\",\n" +
                "                    \"description\": \"Ut eaque mollitia distinctio rerum. Soluta nemo praesentium id fugiat. Tempora et ipsam iste voluptas sunt.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Saepe nam totam qui ut quis.\",\n" +
                "                    \"description\": \"Eos veritatis harum enim ea. Iste nisi dolorem provident assumenda adipisci et quia. Voluptatibus magnam et at voluptatibus a dolore.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Autem est est in.\",\n" +
                "                    \"description\": \"Qui omnis animi deserunt laboriosam quisquam ullam. Deserunt nam et optio quia. Commodi laboriosam eos laboriosam.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 483266567.15,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"531593223.87\",\n" +
                "            \"categories\": [\n" +
                "                \"nobis\",\n" +
                "                \"et\",\n" +
                "                \"facere\",\n" +
                "                \"autem\",\n" +
                "                \"assumenda\",\n" +
                "                \"aut\",\n" +
                "                \"placeat\",\n" +
                "                \"odit\",\n" +
                "                \"accusantium\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"adipisci\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"name\": \"Et quia est illo odit sequi.\",\n" +
                "            \"description\": \"Et neque sit est iure. Eos a officia suscipit ducimus perferendis. Praesentium natus molestias earum voluptates. Est qui et eos iste recusandae mollitia dolores.\",\n" +
                "            \"ean\": \"8757387057357\",\n" +
                "            \"upc\": \"935925572854\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Quo et in dolorum.\",\n" +
                "                    \"description\": \"Omnis delectus rerum quaerat provident minima molestiae quibusdam pariatur. Optio quasi qui beatae incidunt et voluptatem et. Eveniet blanditiis cupiditate dolor. Labore velit expedita quia.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Et ipsa tempora ipsum labore.\",\n" +
                "                    \"description\": \"Vel libero tempore accusantium quibusdam eum deserunt autem qui. Eos et minima nam blanditiis. Veniam officia alias ex.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Vel et et alias non.\",\n" +
                "                    \"description\": \"Consequuntur veritatis quis qui vel iusto. Sed quia voluptatibus quaerat cumque a qui reprehenderit. Doloremque ut quam blanditiis. Expedita reiciendis quae excepturi hic sed et.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 3045352.79,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"3349888.07\",\n" +
                "            \"categories\": [\n" +
                "                \"exercitationem\",\n" +
                "                \"fugiat\",\n" +
                "                \"voluptatem\",\n" +
                "                \"enim\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"qui\",\n" +
                "                \"quia\",\n" +
                "                \"dolore\",\n" +
                "                \"tempora\",\n" +
                "                \"voluptas\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"name\": \"Est vel distinctio eaque a.\",\n" +
                "            \"description\": \"Atque deserunt libero et perferendis. Veritatis provident est perferendis qui voluptas. Doloremque fugiat provident similique nisi debitis similique. Magnam accusantium nemo dolore autem similique.\",\n" +
                "            \"ean\": \"8975396650936\",\n" +
                "            \"upc\": \"432518747262\",\n" +
                "            \"image\": \"http://placeimg.com/640/480/tech\",\n" +
                "            \"images\": [\n" +
                "                {\n" +
                "                    \"title\": \"Et rerum dignissimos et quia.\",\n" +
                "                    \"description\": \"Dolores expedita modi est quidem sed qui quidem. Et ducimus at magnam exercitationem aut nobis quas debitis. Odio inventore ut molestiae nobis possimus explicabo.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Rerum magnam et dolor.\",\n" +
                "                    \"description\": \"Sed recusandae cum fugit et. Est id voluptatem excepturi blanditiis. Placeat delectus omnis soluta aut sit.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"title\": \"Quos aut vel natus.\",\n" +
                "                    \"description\": \"Unde odio sed impedit fuga sed et aperiam. Ipsa voluptates et incidunt et.\",\n" +
                "                    \"url\": \"http://placeimg.com/640/480/any\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"net_price\": 20.01,\n" +
                "            \"taxes\": \"10\",\n" +
                "            \"price\": \"22.01\",\n" +
                "            \"categories\": [\n" +
                "                \"blanditiis\",\n" +
                "                \"voluptatem\",\n" +
                "                \"non\"\n" +
                "            ],\n" +
                "            \"tags\": [\n" +
                "                \"accusantium\",\n" +
                "                \"minus\",\n" +
                "                \"commodi\",\n" +
                "                \"iure\",\n" +
                "                \"sunt\",\n" +
                "                \"voluptates\",\n" +
                "                \"eligendi\",\n" +
                "                \"magnam\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}"

        return Gson().fromJson(responseStr, ProductResponse::class.java)
    }
}