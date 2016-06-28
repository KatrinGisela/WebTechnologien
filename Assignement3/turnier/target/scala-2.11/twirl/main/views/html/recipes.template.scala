
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object recipes_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class recipes extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Recipe],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recipes: List[Recipe]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.25*/(""" 

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Recipes")/*5.17*/ {_display_(Seq[Any](format.raw/*5.19*/("""
"""),format.raw/*6.1*/("""<h1>List of Recipes</h1>
<a href=""""),_display_(/*7.11*/routes/*7.17*/.RecipesCtrl.createRecipe()),format.raw/*7.44*/("""">Create Recipe</a>
<table>
	"""),_display_(/*9.3*/for(recipe <- recipes) yield /*9.25*/ {_display_(Seq[Any](format.raw/*9.27*/("""
	"""),format.raw/*10.2*/("""<tr>
		<td>"""),_display_(/*11.8*/recipe/*11.14*/.name),format.raw/*11.19*/("""</td>
		<td>
			<ul>
				"""),_display_(/*14.6*/for(ingredient <- recipe.ingredients) yield /*14.43*/ {_display_(Seq[Any](format.raw/*14.45*/("""
				"""),format.raw/*15.5*/("""<li>"""),_display_(/*15.10*/ingredient/*15.20*/.name),format.raw/*15.25*/("""</li> """)))}),format.raw/*15.32*/("""
			"""),format.raw/*16.4*/("""</ul>
		</td>
		<td>"""),_display_(/*18.8*/recipe/*18.14*/.description),format.raw/*18.26*/("""</td>
		<td>"""),_display_(/*19.8*/form(routes.RecipesCtrl.updateRecipe(recipe.rid))/*19.57*/ {_display_(Seq[Any](format.raw/*19.59*/(""" 
		"""),format.raw/*20.3*/("""<input type="submit" value="Update"> """)))}),format.raw/*20.41*/("""
		"""),format.raw/*21.3*/("""</td>
		<td>"""),_display_(/*22.8*/form(routes.RecipesCtrl.deleteRecipe(recipe.rid))/*22.57*/ {_display_(Seq[Any](format.raw/*22.59*/(""" 
			"""),format.raw/*23.4*/("""<input type="submit" value="Delete"> """)))}),format.raw/*23.42*/("""
		"""),format.raw/*24.3*/("""</td>
	</tr>
	""")))}),format.raw/*26.3*/("""
"""),format.raw/*27.1*/("""</table>
""")))}),format.raw/*28.2*/("""
"""))
      }
    }
  }

  def render(recipes:List[Recipe]): play.twirl.api.HtmlFormat.Appendable = apply(recipes)

  def f:((List[Recipe]) => play.twirl.api.HtmlFormat.Appendable) = (recipes) => apply(recipes)

  def ref: this.type = this

}


}

/**/
object recipes extends recipes_Scope0.recipes
              /*
                  -- GENERATED --
                  DATE: Tue Jun 28 16:44:26 CEST 2016
                  SOURCE: /home/andreas/webt/recipes/app/views/recipes.scala.html
                  HASH: 057107402780d779e5d4351f02efda9a0d861b9c
                  MATRIX: 755->1|888->24|919->47|947->50|970->65|1009->67|1037->69|1099->105|1113->111|1160->138|1217->170|1254->192|1293->194|1323->197|1362->210|1377->216|1403->221|1458->250|1511->287|1551->289|1584->295|1616->300|1635->310|1661->315|1699->322|1731->327|1780->350|1795->356|1828->368|1868->382|1926->431|1966->433|1998->438|2067->476|2098->480|2138->494|2196->543|2236->545|2269->551|2338->589|2369->593|2416->610|2445->612|2486->623
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|37->7|37->7|37->7|39->9|39->9|39->9|40->10|41->11|41->11|41->11|44->14|44->14|44->14|45->15|45->15|45->15|45->15|45->15|46->16|48->18|48->18|48->18|49->19|49->19|49->19|50->20|50->20|51->21|52->22|52->22|52->22|53->23|53->23|54->24|56->26|57->27|58->28
                  -- GENERATED --
              */
          