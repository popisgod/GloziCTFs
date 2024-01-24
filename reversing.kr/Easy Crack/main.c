void __cdecl FUN_00401080(HWND window_handle)

{
  byte bVar1;
  byte *pbVar2;
  int iVar3;
  char *AGR3versing_string;
  undefined4 *puVar4;
  bool bVar5;
  char input;
  char local_63;
  char cStack_62;
  byte abStack_61 [97];
  
  input = '\0';
  puVar4 = (undefined4 *)&local_63;
  for (iVar3 = 0x18; iVar3 != 0; iVar3 = iVar3 + -1) {
     *puVar4 = 0;
     puVar4 = puVar4 + 1;
  }
  *(undefined2 *)puVar4 = 0;
  *(undefined *)((int)puVar4 + 2) = 0;
  GetDlgItemTextA(window_handle,1000,&input,100);
  if (local_63 == 'a') {
     iVar3 = _strncmp(&local_63 + 1,&DAT_00406078,2);
     if (iVar3 == 0) {
        AGR3versing_string = s_AGR3versing_0040606a;
        pbVar2 = (byte *)(&local_63 + 3);
        do {
           AGR3versing_string = (char *)((byte *)AGR3versing_string + 2);
           bVar1 = *pbVar2;
           bVar5 = bVar1 < (byte)*AGR3versing_string;
           if (bVar1 != *AGR3versing_string) {
LAB_00401102:
              iVar3 = (1 - (uint)bVar5) - (uint)(bVar5 != 0);
              goto LAB_00401107;
           }
           if (bVar1 == 0) break;
           bVar1 = pbVar2[1];
           bVar5 = bVar1 < ((byte *)AGR3versing_string)[1];
           if (bVar1 != ((byte *)AGR3versing_string)[1]) goto LAB_00401102;
           pbVar2 = pbVar2 + 2;
        } while (bVar1 != 0);
        iVar3 = 0;
LAB_00401107:
        if ((iVar3 == 0) && (input == 'E')) {
           MessageBoxA(window_handle,s_Congratulation_!!_00406044,s_EasyCrackMe_00406058,0x40);
           EndDialog(window_handle,0);
           return;
        }
     }
  }
  MessageBoxA(window_handle,s_Incorrect_Password_00406030,s_EasyCrackMe_00406058,0x10);
  return;
}
