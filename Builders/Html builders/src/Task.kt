fun renderProductTable(): String {
    return html {
        table {
            tr (color = getTitleColor()){
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for(( index, product) in products.withIndex() ) {
                tr {
                    td(color = getCellColor(1, index)) {
                        text(product.description)
                    }
                    td(color = getCellColor(2, index)) {
                        text(product.price)
                    }
                    td(color = getCellColor(3, index)) {
                        text(product.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) %2 == 0) "#dce4ff" else "#eff2ff"
