// curl is a linux command line tool to transfer data to or from a server using any supported protocols like HTTP
//Most basic usage is to use curl <websiteURL? then it would return all the HTML/CSS/JS of that URL page
//stdout => standard device output is the default file descriptor where process can write output. Default is 1. Which is the user's screen.
//stder => standard error is the default file descriptor where process can write errors. Default is 2. Which is the user's screen.
//stdin => standard input device is the device from which input to the system is taken. Default is keyboard but you can specify input to be something else
// such as a disk file or a port.

val url = "https://api.github.com/repos/lihaoyi/mill/releases"
os.proc("curl", url).call(stdout = os.pwd / "github.json")
println(os.proc("ls", "-lh", "github.json").call().out.text())

// Here the input is no longer keyboard but rather a file. The contents of that file will then be zipped with command gzip and output will be stdout
//This allows subprocesses to handle larger files and large amounts of data without having to load either the input or oputput into
//the host's process memory. Useful is file is large and memory is limited.
os.proc("gzip").call(stdin = os.pwd / "github.json", stdout = os.pwd / "github.json.gz")
println(os.proc("ls", "-lh", "github.json.gz").call().out.text())

//os.proc.call only allows the spawning of a single subprocess at a time and only returns once that subprocesses has completed.
//Therefore, it can only be used for simple commands like curl and git or gzip.