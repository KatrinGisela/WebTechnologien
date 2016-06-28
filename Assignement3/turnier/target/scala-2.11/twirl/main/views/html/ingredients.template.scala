
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ingredients_Scope0 {
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

class ingredients extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Ingredient],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingredients: List[Ingredient]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.33*/(""" 

"""),_display_(/*3.2*/main("Ingredients")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""

	"""),format.raw/*5.2*/("""<h1>List of ingredients</h1>
	
	<a href=""""),_display_(/*7.12*/routes/*7.18*/.IngredientsCtrl.createIngredient()),format.raw/*7.53*/("""">Create	Ingredient</a>
	<table>
	"""),_display_(/*9.3*/for(ingredient <- ingredients) yield /*9.33*/ {_display_(Seq[Any](format.raw/*9.35*/("""
		"""),format.raw/*10.3*/("""<tr>
			<td>"""),_display_(/*11.9*/ingredient/*11.19*/.name),format.raw/*11.24*/("""</td>
			<td>"""),_display_(/*12.9*/ingredient/*12.19*/.description),format.raw/*12.31*/("""</td>
			<td>"""),_display_(/*13.9*/helper/*13.15*/.form(action =
				routes.IngredientsCtrl.updateIngredient(ingredient.iid))/*14.61*/ {_display_(Seq[Any](format.raw/*14.63*/(""" """),format.raw/*14.64*/("""<input
				type="submit" value="Update"> """)))}),format.raw/*15.36*/("""
			"""),format.raw/*16.4*/("""</td>
			<td>"""),_display_(/*17.9*/helper/*17.15*/.form(action =
				routes.IngredientsCtrl.deleteIngredient(ingredient.iid))/*18.61*/ {_display_(Seq[Any](format.raw/*18.63*/(""" """),format.raw/*18.64*/("""<input
				type="submit" value="Delete"> """)))}),format.raw/*19.36*/("""
			"""),format.raw/*20.4*/("""</td>
		</tr>
	""")))}),format.raw/*22.3*/("""
"""),format.raw/*23.1*/("""</table>
""")))}),format.raw/*24.2*/("""
"""))
      }
    }
  }

  def render(ingredients:List[Ingredient]): play.twirl.api.HtmlFormat.Appendable = apply(ingredients)

  def f:((List[Ingredient]) => play.twirl.api.HtmlFormat.Appendable) = (ingredients) => apply(ingredients)

  def ref: this.type = this

}


}

/**/
object ingredients extends ingredients_Scope0.ingredients
              /*
                  -- GENERATED --
                  DATE: Tue Jun 28 16:44:26 CEST 2016
                  SOURCE: /home/andreas/webt/recipes/app/views/ingredients.scala.html
                  HASH: 1738ec10e195374f9661a8dbb2f953d82b792396
                  MATRIX: 767->1|893->32|924->38|951->57|990->59|1021->64|1091->108|1105->114|1160->149|1222->186|1267->216|1306->218|1337->222|1377->236|1396->246|1422->251|1463->266|1482->276|1515->288|1556->303|1571->309|1656->385|1696->387|1725->388|1799->431|1831->436|1872->451|1887->457|1972->533|2012->535|2041->536|2115->579|2147->584|2195->602|2224->604|2265->615
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|38->7|38->7|38->7|40->9|40->9|40->9|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|45->14|45->14|45->14|46->15|47->16|48->17|48->17|49->18|49->18|49->18|50->19|51->20|53->22|54->23|55->24
                  -- GENERATED --
              */
          