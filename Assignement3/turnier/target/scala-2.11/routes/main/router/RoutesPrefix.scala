
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/andreas/webt/recipes/conf/routes
// @DATE:Tue Jun 28 16:44:25 CEST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
