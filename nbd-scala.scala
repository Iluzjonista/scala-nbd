import scala.annotation.tailrec
object HelloWorld {
   def main(args: Array[String]) {
   
    val dniTygodnia = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")   
    println("------------------")
    println("Zadanie 1a")
    for (i <- dniTygodnia) { println(i) }
    println("------------------")
    println("Zadanie 1b")
    for (i <- dniTygodnia) {          
          if(i.startsWith("P"))
          println(i)          
      }
    println("------------------")
    println("Zadanie 1c")
    dniTygodnia.foreach { println }
    println("------------------")
    println("Zadanie 1d")
    var i :Int = 0;
    while(i < dniTygodnia.length){            
            println(dniTygodnia(i))
            i = i + 1
        }
    println("------------------")
    println("Zadanie 1e")
    println("Rekurencyjnie: ")
    println(rekurencja(dniTygodnia))
    println("------------------")
    println("Zadanie 1f")
    println("Rekurencyjnie w drugą stronę: ")
    println(rekurencja2(dniTygodnia))
    println("------------------")
    println("Zadanie 1g")
    val foldleft = dniTygodnia.foldLeft[String]("") { (_+_+", ") }
		println(foldleft)
    val foldright = dniTygodnia.foldRight[String]("") {(_+", "+_)}
		println(foldright)
    println("------------------")
    println("Zadanie 1h")
    val flp = dniTygodnia.foldLeft[String]("") { (z,f) => if(f.startsWith("P")) z+f+", " else z }
		println(flp)
    println("------------------")
    println("Zadanie 2")
    val product = Map("woda" -> 1, "mąka" -> 3, "chleb" -> 2, "cukierek" -> 120)
		println(product)
    val product2 = product map {case (key, value) => (key, 0.9*value)}
    println(product2)
    println("------------------")
    println("Zadanie 3")
    val krotka = ("to jest krotka", 1, 2.4)
    krotkaWypisz(krotka)
    println("------------------")
    println("Zadanie 4")
    val ulica = Map("Zajezdnia" -> "Woronicza", "Przystanek" -> "Puławska")
    println("Zajezdnia znajduje się na ulicy: "+ ulica.get("Zajezdnia")+", a przystanek jest na ulicy: " + ulica.get("Przystanek")+ " a pasażer jest: " + ulica.get("Pasazer"))
    println("------------------")
    println("Zadanie 5")
    val d1 = "Sobota"
    val d2 = "Wtorek"
    val d3 = "Nie wiem"
    println(jakiDzien(d1),jakiDzien(d2),jakiDzien(d3))
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
    case class Message(imie:String, nazwisko:String){}
       
 def sayHi(p:Message) = p match{
     case Message ("Andrzej", _) => "Cześć Andrzej, jak mija Twój dzień?"
     case Message (_, "Stepien") => "Cześć brat!"
     case Message ("Marek", _) => "Witaj Marku, udany dzień?"
     case _ => "no hejka"
}   
   
    val osoby1 = List(new Message("Andrzej", "Markowski"), new Message("Jan", "Kich"), new Message("Marek", "Koterski"), new Message("Adam", "Stepien"), new Message("Maria", "Kas"))
    
    osoby1.foreach(osoba1 => println(sayHi(osoba1)))
    
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
//---------zadanie1e---------
def rekurencja (list: List[String]): String={
        if (list.isEmpty)
            ""
        else list.head + ", " + rekurencja(list.tail)
    }
//---------zadanie1f---------   
def rekurencja2 (list: List[String]): String={
        if (list.isEmpty)
            ""
        else list.last + ", " + rekurencja2(list.init)
    }
//---------zadanie3---------
def krotkaWypisz (krotka: (String, Int, Double)): Unit={
println("String: " + krotka._1, "Int: " + krotka._2, "Double: " + krotka._3) 
}
//---------zadanie5---------
def jakiDzien(dzienTydzien: String): String = dzienTydzien match {
    case "Poniedzialek" => "Praca"
    case "Wtorek" => "Praca"
    case "Sroda" => "Praca"
    case "Czwartek" => "Praca"
    case "Piatek" => "Praca"
    case "Sobota" => "Weekend"
    case "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia, więc zarządzam wolne"
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

