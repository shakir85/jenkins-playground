package libs

class Utilities {
    static Closure paramProcess(String key, String val) {
        def String newKey = ""
        def String newVal = ""
        return {
            newKey = key+"-new"
            newVal = val+"-val"
        }
    }

    static def buildUrl = "http://foo.bar"
}
