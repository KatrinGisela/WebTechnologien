
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ingredientsForm_Scope0 {
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

class ingredientsForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Form[Ingredient],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(formType: String, ingredientForm: Form[Ingredient]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.54*/(""" 

	"""),_display_(/*3.3*/main(formType + " Ingredient")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
	
	"""),format.raw/*5.2*/("""<h1>"""),_display_(/*5.7*/formType),format.raw/*5.15*/(""" """),format.raw/*5.16*/("""Ingredient</h1>
	
	"""),_display_(/*7.3*/helper/*7.9*/.form(action = routes.IngredientsCtrl.storeIngredient())/*7.65*/ {_display_(Seq[Any](format.raw/*7.67*/("""
	"""),format.raw/*8.2*/("""<input type="hidden" id=""""),_display_(/*8.28*/ingredientForm("iid")/*8.49*/.id),format.raw/*8.52*/(""""
		name=""""),_display_(/*9.10*/ingredientForm("iid")/*9.31*/.name),format.raw/*9.36*/(""""
		value='"""),_display_(/*10.11*/ingredientForm("iid")/*10.32*/.value),format.raw/*10.38*/("""' />
	"""),_display_(/*11.3*/helper/*11.9*/.inputText(ingredientForm("name"))),format.raw/*11.43*/("""
	"""),_display_(/*12.3*/helper/*12.9*/.inputText(ingredientForm("description"))),format.raw/*12.50*/("""
	"""),format.raw/*13.2*/("""<input type="submit" value="Save">
	""")))}),format.raw/*14.3*/(""" 
""")))}),format.raw/*15.2*/("""
"""))
      }
    }
  }

  def render(formType:String,ingredientForm:Form[Ingredient]): play.twirl.api.HtmlFormat.Appendable = apply(formType,ingredientForm)

  def f:((String,Form[Ingredient]) => play.twirl.api.HtmlFormat.Appendable) = (formType,ingredientForm) => apply(formType,ingredientForm)

  def ref: this.type = this

}


}

/**/
object ingredientsForm extends ingredientsForm_Scope0.ingredientsForm
              /*
                  -- GENERATED --
                  DATE: Tue Jun 28 16:44:25 CEST 2016
                  SOURCE: /home/andreas/webt/recipes/app/views/ingredientsForm.scala.html
                  HASH: 3fcfa8e807329ff4eb54915a20887c30274a5a7c
                  MATRIX: 782->1|929->53|961->60|999->90|1038->92|1070->98|1100->103|1128->111|1156->112|1203->134|1216->140|1280->196|1319->198|1348->201|1400->227|1429->248|1452->251|1490->263|1519->284|1544->289|1584->302|1614->323|1641->329|1675->337|1689->343|1744->377|1774->381|1788->387|1850->428|1880->431|1948->469|1982->473
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|36->5|36->5|36->5|38->7|38->7|38->7|38->7|39->8|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|45->14|46->15
                  -- GENERATED --
              */
          