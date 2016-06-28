
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object recipesForm_Scope0 {
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

class recipesForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Form[Recipe],List[models.Ingredient],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(formType: String, recipeForm: Form[Recipe], ingredients: List[models.Ingredient]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.84*/(""" 

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(formType + " Recipe")/*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""
	"""),format.raw/*6.2*/("""<h1>"""),_display_(/*6.7*/formType),format.raw/*6.15*/(""" """),format.raw/*6.16*/("""Recipe</h1>
	"""),_display_(/*7.3*/form(routes.RecipesCtrl.storeRecipe())/*7.41*/ {_display_(Seq[Any](format.raw/*7.43*/("""
		"""),format.raw/*8.3*/("""<input type="hidden" id=""""),_display_(/*8.29*/recipeForm("rid")/*8.46*/.id),format.raw/*8.49*/(""""
		name=""""),_display_(/*9.10*/recipeForm("rid")/*9.27*/.name),format.raw/*9.32*/("""" 
		value='"""),_display_(/*10.11*/recipeForm("rid")/*10.28*/.value),format.raw/*10.34*/("""' />
	"""),_display_(/*11.3*/inputText(recipeForm("name"))),format.raw/*11.32*/("""
	"""),format.raw/*12.2*/("""<div>
		<div>
			<strong>Ingredients</strong>
		</div>
	<div>
	"""),_display_(/*17.3*/for(ingredient <- ingredients) yield /*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/(""" 
		"""),format.raw/*18.3*/("""<label class="checkbox"> 
		<input type="checkbox" name="ingredients.iid[]" value=""""),_display_(/*19.59*/ingredient/*19.69*/.iid),format.raw/*19.73*/(""""
			"""),_display_(/*20.5*/if(recipeForm.value.isDefined &&
				recipeForm.value.get.ingredients.contains(ingredient))/*21.59*/ {_display_(Seq[Any](format.raw/*21.61*/("""			
					"""),format.raw/*22.6*/("""checked="checked" 
			""")))}),format.raw/*23.5*/("""
		"""),format.raw/*24.3*/("""/>
		"""),_display_(/*25.4*/ingredient/*25.14*/.name),format.raw/*25.19*/("""
		"""),format.raw/*26.3*/("""</label> """)))}),format.raw/*26.13*/("""
	"""),format.raw/*27.2*/("""</div>
</div>
"""),_display_(/*29.2*/textarea(field = recipeForm("description"), args = 'rows -> 3, 'cols -> 50)),format.raw/*29.77*/("""
"""),format.raw/*30.1*/("""<input type="submit" value="Save">
	""")))}),format.raw/*31.3*/(""" 
""")))}),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(formType:String,recipeForm:Form[Recipe],ingredients:List[models.Ingredient]): play.twirl.api.HtmlFormat.Appendable = apply(formType,recipeForm,ingredients)

  def f:((String,Form[Recipe],List[models.Ingredient]) => play.twirl.api.HtmlFormat.Appendable) = (formType,recipeForm,ingredients) => apply(formType,recipeForm,ingredients)

  def ref: this.type = this

}


}

/**/
object recipesForm extends recipesForm_Scope0.recipesForm
              /*
                  -- GENERATED --
                  DATE: Tue Jun 28 16:44:25 CEST 2016
                  SOURCE: /home/andreas/webt/recipes/app/views/recipesForm.scala.html
                  HASH: 741c5d9353d24d00af97fb120843c455d768c362
                  MATRIX: 794->1|986->83|1017->107|1045->110|1079->136|1118->138|1147->141|1177->146|1205->154|1233->155|1273->170|1319->208|1358->210|1388->214|1440->240|1465->257|1488->260|1526->272|1551->289|1576->294|1617->308|1643->325|1670->331|1704->339|1754->368|1784->371|1879->440|1925->470|1965->472|1997->477|2109->562|2128->572|2153->576|2186->583|2287->675|2327->677|2364->687|2418->711|2449->715|2482->722|2501->732|2527->737|2558->741|2599->751|2629->754|2672->771|2768->846|2797->848|2865->886|2899->890
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|36->6|36->6|36->6|37->7|37->7|37->7|38->8|38->8|38->8|38->8|39->9|39->9|39->9|40->10|40->10|40->10|41->11|41->11|42->12|47->17|47->17|47->17|48->18|49->19|49->19|49->19|50->20|51->21|51->21|52->22|53->23|54->24|55->25|55->25|55->25|56->26|56->26|57->27|59->29|59->29|60->30|61->31|62->32
                  -- GENERATED --
              */
          