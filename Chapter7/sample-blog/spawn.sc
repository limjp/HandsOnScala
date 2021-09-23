//This file is for when we want more control over subprocess or want multiple subprocesses
//os.proc.spawn takes a similar set of arguments as os.proc.call and instead of returning a completed os.CommandResult, returns os.SubProcess object.
//Object represents a subporcess that runs in the background while the program continues to execute. Can interact with it via stdin, stdout and stderr streams

val gitLog = os.proc("git", "log").spawn()
val grepAuthor = os.proc("grep", "Author: ").spawn(stdin = gitLog.stdout)
val output = grepAuthor.stdout.lines().distinct

println(output)