// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    return customers.flatMap { it.orders }.flatMap { it.products }.fold(HashSet()) { products, element ->
        products.also {
            if (customers.all {customer -> customer.isCustomerOrderProduct(element) }) {
                it.add(element)
            }
        }
    }
}

fun Customer.isCustomerOrderProduct(product: Product): Boolean = orders.flatMap { it.products }.any { it == product }