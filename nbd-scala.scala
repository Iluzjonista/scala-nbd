import scala.collection.immutable.Range.Inclusive
object HelloWorld {
   def main(args: Array[String]) {
       
    println("------------------")
    println("Zadanie 6") 
    val konto1 = new KontoBankowe()
    val konto2 = new KontoBankowe(100)

    println(konto1.getstanKonta)
    println(konto2.getstanKonta)
    konto1.wplata(500)
    println(konto1.getstanKonta)
    konto1.wyplata(100)
    println(konto1.getstanKonta)
    println("------------------") 
    println("Zadanie 7") 
    val osoba1 = new Osoba("Jan", "Kowalski")
	println(Osoba.p(osoba1))
    val osoby = List(new Osoba("Andrzej", "Markowski"), new Osoba("Jan", "Kich"), new Osoba("Marek", "Koterski"), new Osoba("Adam", "Stepien"), new Osoba("Maria", "Kas"))
    osoby.foreach(osoba => println(Osoba p osoba))
    
    println("------------------")
    println("Zadanie 8")     
    val liczby8 = List(1, 0, 3, 0, 5, 10, 7)
    println("Lista po usunięciu zer: " + listaBezZer(liczby8))
    
    println("------------------")
    println("Zadanie 9") 
    val liczby9 = List(1, 2, 3, 4, 5, 6, 7)
    println("Liczby przed operacją zwiększenia: " + liczby9)
    println("Liczby po operacji zwiększenia: " + listaZwieksz(liczby9))
    println("------------------")
    println("Zadanie 10") 
    val liczby10 = List(11, -22, -3, 4, -2, 0, 7, 26, 12, -5, -12)
    println("Liczby przed: " + liczby10)
    println("Liczby po: " + wartBezw(liczby10))
    
   }
   
//---------zadanie8---------

def listaBezZer(liczby : List[Int]): List[Int] = {
    liczby.filterNot (_==0)
  }
//---------zadanie9---------
def listaZwieksz(liczby : List[Int]): List[Int] = {
    liczby.map((i) => i+1)
  }
//---------zadanie10---------
def wartBezw(liczby : List[Int]): List[Int] = {
  
  liczby.filter(-5<=_).filter(_<=12).map (_ abs)
  }
}
//---------zadanie6---------
class KontoBankowe(private var stanKonta: Int = 0){
  def getstanKonta = stanKonta

  def wplata(i: Int): Unit = {
    this.stanKonta += i
  }

  def wyplata(i: Int): Unit = {
    this.stanKonta -= i
  }
}

//---------zadanie7---------

class Osoba(var imie:String, var nazwisko:String){
}

object Osoba{
    def p(x: Osoba): String = {
        x match {
            case andrzej if x.imie == "Andrzej" => "Cześć Andrzej, jak mija Twój dzień?"
            case stepien if x.nazwisko == "Stepien" => "Cześć brat!"
            case marek if x.imie == "Marek" => "Witaj Marku, udany dzień?"
            case _ => "no hejka"
            
        }
    }
}