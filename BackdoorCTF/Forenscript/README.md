# Forenscript 
It's thundering outside and you are you at your desk having solved 4 forensics challenges so far. Just pray to god you solve this one. You might want to know that sometimes too much curiosity hides the flag.



[included file](https://github.com/popisgod/CTFs/blob/main/BackdoorCTF/Forenscript/public/a.bin)

<details>
  <summary><h2>Solution</h2></summary>
  <p>
    Upon examining the binary data of the provided file, it became evident that the file is in the PNG format.<br>
    However, an unusual pattern was observed where every 4 bytes appeared to be reversed, for example:<br>
    <pre>47 4E 50 89 0A 1A 0A 0D</pre>
    which appeared as:<br><br>
    <pre>GNP </pre>
    To restore the original order, I utilized a <a href="https://github.com/popisgod/CTFs/blob/main/BackdoorCTF/Forenscript/solution.py">Python script</a> to reverse the bytes back to their original sequence. 
    This resulted in the generation of <a href="https://github.com/popisgod/CTFs/blob/main/BackdoorCTF/Forenscript/output.png">this corrected image</a>.<br>
    Subsequently, I employed the <code>binwalk</code> tool on the corrected image and uncovered the presence of another embedded PNG file. 
    Extraction of the embedded file was executed using the following command:<br><br>
    <pre>binwalk -D 'png image:png' output.png</pre>
    The extracted <a href="https://github.com/popisgod/CTFs/blob/main/BackdoorCTF/Forenscript/_output.png-0.extracted/EA90.png">PNG file</a> contained the flag.
  </p>
</details>

##

<details> 
 <summary><h2>&nbspflag</h2></summary> 
  <pre> flag{scr1pt1ng_r34lly_t0ugh_a4n't_1t??} </pre> 
</details>
