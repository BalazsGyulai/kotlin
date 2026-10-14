package bike

data class BikeId(val code: String){
    init {
        require(code.length == 4){"bike id must look like C-01, was '${code}'"}
        require(code[0].isUpperCase()){"bike id must look like C-01, was '${code}'"}
        require(code[1] == '-'){"bike id must look like C-01, was '${code}'"}
        require(code[2].isDigit()){"bike id must look like C-01, was '${code}'"}
        require(code[3].isDigit()){"bike id must look like C-01, was '${code}'"}
    }
}
