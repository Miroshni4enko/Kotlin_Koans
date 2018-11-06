class LazyProperty(val initializer: () -> Int) {
    private var value: Int? = null
    val lazy: Int
        get() {
             if (value == null){
                value = initializer()
            }
            return value!!
        }
}

fun main(args: Array<String>) {
    val lazyProperty = LazyProperty { 23 }
    lazyProperty.lazy
}
