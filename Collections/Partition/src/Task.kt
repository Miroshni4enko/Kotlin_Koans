// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = customers.filter { it.undeliveredOrdersMore() }.toSet()

fun Customer.undeliveredOrdersMore(): Boolean {
    val (delivered, undelivered) =  orders.partition { it.isDelivered }
    return delivered.size < undelivered.size
}
