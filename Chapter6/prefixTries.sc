// Trie AKA Prefix Tree is a tree shape data structure that behaves similar to Set[String] i.e. it is meant to hold a strings and there can be no repeats
// Has methods like add, contains, prefixesMatch - meant to find all string in Trie which are a prefix of the string s, stringsMatchingPrefix - query the Tries for
// all strings which contain a string S as a prefix.
// Each node in Trie contain a character. Words that share prefixes share nodes till they branch of.
// Each node has a map of characters to child nodes. hasValue field represents Xs i.e. complete words and indicate if the node is the last node in a string

class Trie() {
  class Node(var hasValue: Boolean, val children: collection.mutable.Map[Char, Node] = collection.mutable.Map())
  val root = new Node(false)
}