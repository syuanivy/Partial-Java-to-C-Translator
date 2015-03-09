#!/usr/bin/env python

# bootstrap by downloading bilder.py if not found
import urllib
import os
import glob

# ASSUMES YOU HAVE GNU indent installed. ($ brew install gnu-indent on mac os x)
# Executable is gindent
# http://www.gnu.org/software/indent/manual/


if not os.path.exists("bilder.py"):
    print "bootstrapping; downloading bilder.py"
    urllib.urlretrieve(
        "https://raw.githubusercontent.com/parrt/bild/master/src/python/bilder.py",
        "bilder.py")

# assumes bilder.py is in current directory
from bilder import *

def parser():
    antlr4(srcdir="src/cs652/j/parser", trgdir="gen",
           package="cs652.j.parser",
           version="4.5",
           args=["-visitor"])


def compile():
    require(parser)
    javac("src", "out", javacVersion="1.8", cp="src:gen:out:resources:"+JARCACHE+"/antlr-4.5-complete.jar")


def mkjar():
    require(compile)
    mkdir("dist")
    jarfile = "dist/jtran.jar"
    manifest = \
        "Main-Class: cs652.j.JTran\n" +\
        "Implementation-Title: JTran Java to C translator\n" +\
        "Implementation-Vendor-Id: org.antlr\n" +\
        "Built-By: %s\n" +\
        "Build-Jdk: 1.8\n" +\
        "Created-By: http://www.bildtool.org\n" +\
        "\n"
    manifest = manifest % os.getlogin()
    download("http://www.antlr.org/download/antlr-4.5-complete.jar", JARCACHE)
    unjar(os.path.join(JARCACHE, "antlr-4.5-complete.jar"), trgdir="out")
    copyfile("resources/cs652/j/templates/C.stg", "out/cs652/j/templates/C.stg")
    jar(jarfile, srcdir="out", manifest=manifest)
    print_and_log("Generated " + jarfile)


def test(jfile):
    log("TEST "+jfile)
    print("TEST "+jfile)
    dir = os.path.dirname(jfile)
    base = os.path.basename(jfile)
    base = os.path.splitext(base)[0]
    cfile = base+".c"
    expected_cfile = dir+"/"+cfile
    expected_output = dir+"/"+base+".txt"
    java(classname="cs652.j.JTran", cp="out:resources:"+JARCACHE+"/antlr-4.5-complete.jar",
         progargs=["-o", "/tmp/"+cfile, jfile])
    executable = "/tmp/" + base
    CC = ["gcc", "-o", executable, "/tmp/"+cfile]
    exec_and_log(CC)
    log(executable+" &> /tmp/"+base+".txt")
    os.system(executable+" &> /tmp/"+base+".txt")
    # normalize the file
    indent_args = ["-bap", "-bad", "-br", "-nce", "-ncs", "-nprs", "-npcs", "-sai", "-saw",
                   "-di1", "-brs", "-blf", "--indent-level4", "-nut", "-sob", "-l200"]
    exec_and_log(["gindent"]+indent_args+["/tmp/"+cfile])
    # compare with expected c file but first format the expected file as well
    exec_and_log(["gindent"]+indent_args+[expected_cfile, "-o", "/tmp/expected_"+base+".c"])
    exec_and_log(["diff", "/tmp/expected_"+base+".c", "/tmp/"+cfile])
    # compare with expected output
    exec_and_log(["diff", expected_output, "/tmp/"+base+".txt"])


def tests():
    require(compile)
    for file in glob.glob("tests/cs652/j/*.j"):
        test(file)


def clean():
    rmdir("out")
    rmdir("gen")


def all():
    tests()

processargs(globals())
