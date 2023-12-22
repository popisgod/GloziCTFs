# Headache
I've had a headache since last evening. Is there a magic spell that can cure it immediately?

[included file](https://github.com/popisgod/CTFs/blob/main/BackdoorCTF/Headache/public/original/chal.png)

<details>
  <summary><h2>&nbspsolution</h2></summary>
the file included bears the file extension .PNG but it doesn't open in standard image viewers. <br> 
using the 'xxd' command I found out the signture of the PNG file was corrupted. <br> 
The start of every standard PNG file should include:<br><br> 
  <pre>89 50 4E 47 0D 0A 1A 0A</pre> 
However, In the provided file, this section had a different hexadecimal value:<br><br>
  <pre>AE 71 00 FF 3D 62 24 6D</pre>
Changing the incorrect signature allows the file to be opened, and the key is located inside the 
<a href="https://github.com/popisgod/CTFs/blob/main/BackdoorCTF/Headache/public/repaired/chal.png"> repaired image</a>

</details>

##

<details> 
 <summary><h2>&nbspflag</h2></summary> 
  <pre> flag{sp3ll_15_89_50_4E_47} </pre> 
</details>
