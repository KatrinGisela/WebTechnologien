
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/andreas/webt/recipes/conf/routes
// @DATE:Tue Jun 28 16:44:25 CEST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:29
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseRecipesCtrl(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def deleteRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipesCtrl.deleteRecipe",
      """
        function(rid0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recipes/delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("rid", rid0)})
        }
      """
    )
  
    // @LINE:17
    def readRecipes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipesCtrl.readRecipes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recipes"})
        }
      """
    )
  
    // @LINE:18
    def storeRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipesCtrl.storeRecipe",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recipes/store"})
        }
      """
    )
  
    // @LINE:19
    def createRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipesCtrl.createRecipe",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recipes/create"})
        }
      """
    )
  
    // @LINE:20
    def updateRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipesCtrl.updateRecipe",
      """
        function(rid0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recipes/update/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("rid", rid0)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseIngredientsCtrl(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def readIngredients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientsCtrl.readIngredients",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredients"})
        }
      """
    )
  
    // @LINE:13
    def updateIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientsCtrl.updateIngredient",
      """
        function(iid0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredients/update/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("iid", iid0)})
        }
      """
    )
  
    // @LINE:11
    def storeIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientsCtrl.storeIngredient",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredients/store"})
        }
      """
    )
  
    // @LINE:14
    def deleteIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientsCtrl.deleteIngredient",
      """
        function(iid0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredients/delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("iid", iid0)})
        }
      """
    )
  
    // @LINE:12
    def createIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientsCtrl.createIngredient",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredients/create"})
        }
      """
    )
  
  }


}
