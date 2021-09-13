sealed trait Expr
case class BinOp(left: Expr, op: String, right: Expr) extends Expr
case class Literal(value: Int) extends Expr
case class Variable(name:String) extends Expr

BinOp(Variable("x"), "+", Literal(1))

BinOp(
  Variable("x"),
  "*",
  BinOp(Variable("y"), "-", Literal(1)
))

BinOp(
  BinOp(Variable("x"), "+", Literal(1)),
  "*",
  BinOp(Variable("y"), "-", Literal(1))
)

def stringify(expr: Expr): String = expr match {
  case Literal(value) => s"$value"
  case Variable(name) => s"$name"
  case BinOp(left, op, right) => s"(${stringify(left)} $op ${stringify(right)})"
    // we have to put strinfy in {} within the s string interpolator beacuse it is an expression.
    // $ can only be used for variables
}

def evaluate(expr: Expr, values: Map[String, Int]): Int = expr match {
  case BinOp(left, "+", right) => evaluate(left, values) + evaluate(right, values)
  case BinOp(left, "-", right) => evaluate(left, values) - evaluate(right, values)
  case BinOp(left, "*", right) => evaluate(left, values) * evaluate(right, values)
  case Literal(value) => value
  case Variable(name) => values(name)
}

val smallerExpr = BinOp(
  Variable("x"),
  "+",
  Literal(1)
)

println(stringify(smallerExpr))
println(evaluate(smallerExpr, Map("x" -> 10)))