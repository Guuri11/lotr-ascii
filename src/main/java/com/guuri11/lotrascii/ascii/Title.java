package com.guuri11.lotrascii.ascii;

/**
 * Art by Blazej Kozlowski https://www.asciiart.eu/books/lord-of-the-rings
 */
public class Title {
  private static final String title = """
               ___ . .  _
        $$$P    |  |_| |_
        $$$     |  | | |_
        $$$                                                        $$$$$$$b.
        $$$     .g$$$$$p.   T$$$$b.    T$$$$$bp.                   BUG    'Tb      T$b      T$P   .g$P^^T$$  ,gP^^T$$
        $$$    d^'     '^b   $$  'Tb    $$    'Tb    .s^s. :sssp   $$$     :$; T$$P $^b.     $   dP'     `T :$P    `T
        :$$   dP         Tb  $$   :$;   $$      Tb  d'   `b $      $$$     :$;  $$  $ `Tp    $  d$           Tbp.
        :$$  :$;         :$; $$   :$;   $$      :$; T.   .P $^^    $$$    .dP   $$  $   ^b.  $ :$;            'T$$p.
        $$$  :$;         :$; $$...dP    $$      :$;  `^s^' .$.     $$$...dP'    $$  $    `Tp $ :$;     'T$$      'T$b
        $$$   Tb.       ,dP  $$'''Tb    $$      dP ""$""$" "$"$^^  $$$""T$b     $$  $      ^b$  T$       T$ ;      $$;
        $$$    Tp._   _,gP   $$   `Tb.  $$    ,dP    $  $...$ $..  $$$   T$b    :$  $       `$   Tb.     :$ T.    ,dP
        $$$;    '^$$$$$^'   d$$     `T.d$$$$$P^'     $  $'''$ $'', $$$    T$b  d$$bd$b      d$b   '^TbsssP' 'T$bgd$P
        $$$b.____.dP                                 $ .$. .$.$ss,d$$$b.   T$b.
      .d$$$$$$$$$$P

                                                                                            ASCII Game by Sergio Gurillo
        """;

  public static void getTitle() {
    System.out.println(title);
  }
}
