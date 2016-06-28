
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/andreas/webt/recipes/conf/routes
// @DATE:Tue Jun 28 16:44:25 CEST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:10
  IngredientsCtrl_4: controllers.IngredientsCtrl,
  // @LINE:17
  RecipesCtrl_2: controllers.RecipesCtrl,
  // @LINE:24
  CountController_0: controllers.CountController,
  // @LINE:26
  AsyncController_3: controllers.AsyncController,
  // @LINE:29
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:10
    IngredientsCtrl_4: controllers.IngredientsCtrl,
    // @LINE:17
    RecipesCtrl_2: controllers.RecipesCtrl,
    // @LINE:24
    CountController_0: controllers.CountController,
    // @LINE:26
    AsyncController_3: controllers.AsyncController,
    // @LINE:29
    Assets_5: controllers.Assets
  ) = this(errorHandler, HomeController_1, IngredientsCtrl_4, RecipesCtrl_2, CountController_0, AsyncController_3, Assets_5, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, IngredientsCtrl_4, RecipesCtrl_2, CountController_0, AsyncController_3, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredients""", """controllers.IngredientsCtrl.readIngredients()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredients/store""", """controllers.IngredientsCtrl.storeIngredient()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredients/create""", """controllers.IngredientsCtrl.createIngredient()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredients/update/""" + "$" + """iid<[^/]+>""", """controllers.IngredientsCtrl.updateIngredient(iid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredients/delete/""" + "$" + """iid<[^/]+>""", """controllers.IngredientsCtrl.deleteIngredient(iid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipes""", """controllers.RecipesCtrl.readRecipes()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipes/store""", """controllers.RecipesCtrl.storeRecipe()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipes/create""", """controllers.RecipesCtrl.createRecipe()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipes/update/""" + "$" + """rid<[^/]+>""", """controllers.RecipesCtrl.updateRecipe(rid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipes/delete/""" + "$" + """rid<[^/]+>""", """controllers.RecipesCtrl.deleteRecipe(rid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_IngredientsCtrl_readIngredients1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredients")))
  )
  private[this] lazy val controllers_IngredientsCtrl_readIngredients1_invoker = createInvoker(
    IngredientsCtrl_4.readIngredients(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientsCtrl",
      "readIngredients",
      Nil,
      "GET",
      """ Ingredients""",
      this.prefix + """ingredients"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_IngredientsCtrl_storeIngredient2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredients/store")))
  )
  private[this] lazy val controllers_IngredientsCtrl_storeIngredient2_invoker = createInvoker(
    IngredientsCtrl_4.storeIngredient(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientsCtrl",
      "storeIngredient",
      Nil,
      "POST",
      """""",
      this.prefix + """ingredients/store"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_IngredientsCtrl_createIngredient3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredients/create")))
  )
  private[this] lazy val controllers_IngredientsCtrl_createIngredient3_invoker = createInvoker(
    IngredientsCtrl_4.createIngredient(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientsCtrl",
      "createIngredient",
      Nil,
      "GET",
      """""",
      this.prefix + """ingredients/create"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_IngredientsCtrl_updateIngredient4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredients/update/"), DynamicPart("iid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientsCtrl_updateIngredient4_invoker = createInvoker(
    IngredientsCtrl_4.updateIngredient(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientsCtrl",
      "updateIngredient",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """ingredients/update/""" + "$" + """iid<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_IngredientsCtrl_deleteIngredient5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredients/delete/"), DynamicPart("iid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientsCtrl_deleteIngredient5_invoker = createInvoker(
    IngredientsCtrl_4.deleteIngredient(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientsCtrl",
      "deleteIngredient",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """ingredients/delete/""" + "$" + """iid<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_RecipesCtrl_readRecipes6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipes")))
  )
  private[this] lazy val controllers_RecipesCtrl_readRecipes6_invoker = createInvoker(
    RecipesCtrl_2.readRecipes(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipesCtrl",
      "readRecipes",
      Nil,
      "GET",
      """ Recipes""",
      this.prefix + """recipes"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_RecipesCtrl_storeRecipe7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipes/store")))
  )
  private[this] lazy val controllers_RecipesCtrl_storeRecipe7_invoker = createInvoker(
    RecipesCtrl_2.storeRecipe(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipesCtrl",
      "storeRecipe",
      Nil,
      "POST",
      """""",
      this.prefix + """recipes/store"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_RecipesCtrl_createRecipe8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipes/create")))
  )
  private[this] lazy val controllers_RecipesCtrl_createRecipe8_invoker = createInvoker(
    RecipesCtrl_2.createRecipe(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipesCtrl",
      "createRecipe",
      Nil,
      "GET",
      """""",
      this.prefix + """recipes/create"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_RecipesCtrl_updateRecipe9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipes/update/"), DynamicPart("rid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipesCtrl_updateRecipe9_invoker = createInvoker(
    RecipesCtrl_2.updateRecipe(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipesCtrl",
      "updateRecipe",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """recipes/update/""" + "$" + """rid<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_RecipesCtrl_deleteRecipe10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipes/delete/"), DynamicPart("rid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipesCtrl_deleteRecipe10_invoker = createInvoker(
    RecipesCtrl_2.deleteRecipe(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipesCtrl",
      "deleteRecipe",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """recipes/delete/""" + "$" + """rid<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_CountController_count11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count11_invoker = createInvoker(
    CountController_0.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_AsyncController_message12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message12_invoker = createInvoker(
    AsyncController_3.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Assets_versioned13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned13_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:10
    case controllers_IngredientsCtrl_readIngredients1_route(params) =>
      call { 
        controllers_IngredientsCtrl_readIngredients1_invoker.call(IngredientsCtrl_4.readIngredients())
      }
  
    // @LINE:11
    case controllers_IngredientsCtrl_storeIngredient2_route(params) =>
      call { 
        controllers_IngredientsCtrl_storeIngredient2_invoker.call(IngredientsCtrl_4.storeIngredient())
      }
  
    // @LINE:12
    case controllers_IngredientsCtrl_createIngredient3_route(params) =>
      call { 
        controllers_IngredientsCtrl_createIngredient3_invoker.call(IngredientsCtrl_4.createIngredient())
      }
  
    // @LINE:13
    case controllers_IngredientsCtrl_updateIngredient4_route(params) =>
      call(params.fromPath[Long]("iid", None)) { (iid) =>
        controllers_IngredientsCtrl_updateIngredient4_invoker.call(IngredientsCtrl_4.updateIngredient(iid))
      }
  
    // @LINE:14
    case controllers_IngredientsCtrl_deleteIngredient5_route(params) =>
      call(params.fromPath[Long]("iid", None)) { (iid) =>
        controllers_IngredientsCtrl_deleteIngredient5_invoker.call(IngredientsCtrl_4.deleteIngredient(iid))
      }
  
    // @LINE:17
    case controllers_RecipesCtrl_readRecipes6_route(params) =>
      call { 
        controllers_RecipesCtrl_readRecipes6_invoker.call(RecipesCtrl_2.readRecipes())
      }
  
    // @LINE:18
    case controllers_RecipesCtrl_storeRecipe7_route(params) =>
      call { 
        controllers_RecipesCtrl_storeRecipe7_invoker.call(RecipesCtrl_2.storeRecipe())
      }
  
    // @LINE:19
    case controllers_RecipesCtrl_createRecipe8_route(params) =>
      call { 
        controllers_RecipesCtrl_createRecipe8_invoker.call(RecipesCtrl_2.createRecipe())
      }
  
    // @LINE:20
    case controllers_RecipesCtrl_updateRecipe9_route(params) =>
      call(params.fromPath[Long]("rid", None)) { (rid) =>
        controllers_RecipesCtrl_updateRecipe9_invoker.call(RecipesCtrl_2.updateRecipe(rid))
      }
  
    // @LINE:21
    case controllers_RecipesCtrl_deleteRecipe10_route(params) =>
      call(params.fromPath[Long]("rid", None)) { (rid) =>
        controllers_RecipesCtrl_deleteRecipe10_invoker.call(RecipesCtrl_2.deleteRecipe(rid))
      }
  
    // @LINE:24
    case controllers_CountController_count11_route(params) =>
      call { 
        controllers_CountController_count11_invoker.call(CountController_0.count)
      }
  
    // @LINE:26
    case controllers_AsyncController_message12_route(params) =>
      call { 
        controllers_AsyncController_message12_invoker.call(AsyncController_3.message)
      }
  
    // @LINE:29
    case controllers_Assets_versioned13_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned13_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
