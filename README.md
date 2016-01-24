# Morse Code Library

With this library you're able to encode a text into morse and decode morse into a text.

# How to use

## Run

### Normal (to use with every option except --help)

``` sh
java -jar Morsecoder.jar
```

### Help

``` sh
java -jar Morsecoder.jar --help (displays all possible options)
```

***

## Convert

### Text to morsecode (encode)

Single word

``` sh
[...] -e text
```

Multiple words

``` sh
[...] -e "some random text"
```

### Morsecode to text (decode)

Single word

``` sh
[...] -d .../---/... #one slash indents the end of a letter
```

Multiple words

``` sh
[...] -d .../---/...//.../---/... #two slashes indent the end of a word
```

***

##  Play

The general use of the play option (-p) follows the same syntax as encoding and decoding. Example:

``` sh
[...] -p "some random text"
```

or

``` sh
[...] -p .../---/...//.../---/...
```

### Settings

Furthermore you can set the pause length between two words (-sPauseSpeed) and/or how fast the whole morsecode is played (-sPlaySpeed).

### Important!

**All** the settings options have to be before the -p option. Otherwise they won't have any effect.

Pausespeed

``` sh
[...] -sPauseSpeed=5000 [...] #the number after = is the time in milliseconds
```

Playspeed

``` sh
[...] -sPlaySpeed=NORMAL [...] #Possible values are: NORMAL, MODERATE, FAST, VERYFAST
```

***

### Prosigns

There are several prosigns available. If you're going to use them you have to use a square bracket before and after it. Example:

``` sh
[...] -e [SK]
```

For more information read [this](https://en.wikipedia.org/wiki/Prosigns_for_Morse_code) article.

## Authors

* [Emanuele Mazzotta](mailto:hello@mazzotta.me)
* Patrick Bächli

## License

See the [LICENSE](LICENSE.md) file for license rights and limitations (MIT).
