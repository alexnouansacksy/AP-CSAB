// Alex Nouansacksy
// MSOE 2017 Question 5
// 10/25/2023
import java.util.*;
import static java.lang.System.out;

public class MSOE2017_5 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int[] days =  new int[365];
        ArrayList<Integer> kids = new ArrayList<>();

        out.print("Enter child tolerability: ");
        int kid = keyboard.nextInt();

        while (kid != 0) {
            kids.add(kid);
            out.print("Enter child tolerability: ");
            kid = keyboard.nextInt();
        }

        for (int i = 0; i < kids.size(); i++) {
            for (int j = 0; j < days.length - kids.get(i) +1; j++) {
                j += kids.get(i) - 1;
                if (days[j] == 0) {
                    days[j] = kids.get(i);
                } else {
                    Boolean added = false;
                    for (int k = 0;k < kids.get(i); k++) {
                        j--;
                        if (days[j] == 0) {
                            days[j] = kids.get(i);
                            added = true;
                            break;
                        }
                    }
                    if (!added){
                        out.println("family is too picky.");
                        System.exit(0);
                    }
                }
            }
        }

        for (int i = 0; i < days.length; i++){
            if (days[i] == 0) out.printf("Day %d: any pizza\n", i);
            else out.printf("Day %d: pizza %d\n", i, days[i]);
        }

    }
}
/*
Enter child tolerability: 3
Enter child tolerability: 4
Enter child tolerability: 5
Enter child tolerability: 0
Day 0: any pizza
Day 1: any pizza
Day 2: pizza 3
Day 3: pizza 4
Day 4: pizza 5
Day 5: pizza 3
Day 6: any pizza
Day 7: pizza 4
Day 8: pizza 3
Day 9: pizza 5
Day 10: pizza 4
Day 11: pizza 3
Day 12: pizza 5
Day 13: pizza 4
Day 14: pizza 3
Day 15: pizza 5
Day 16: pizza 4
Day 17: pizza 3
Day 18: pizza 5
Day 19: pizza 4
Day 20: pizza 3
Day 21: pizza 5
Day 22: pizza 4
Day 23: pizza 3
Day 24: pizza 5
Day 25: pizza 4
Day 26: pizza 3
Day 27: pizza 5
Day 28: pizza 4
Day 29: pizza 3
Day 30: pizza 5
Day 31: pizza 4
Day 32: pizza 3
Day 33: pizza 5
Day 34: pizza 4
Day 35: pizza 3
Day 36: pizza 5
Day 37: pizza 4
Day 38: pizza 3
Day 39: pizza 5
Day 40: pizza 4
Day 41: pizza 3
Day 42: pizza 5
Day 43: pizza 4
Day 44: pizza 3
Day 45: pizza 5
Day 46: pizza 4
Day 47: pizza 3
Day 48: pizza 5
Day 49: pizza 4
Day 50: pizza 3
Day 51: pizza 5
Day 52: pizza 4
Day 53: pizza 3
Day 54: pizza 5
Day 55: pizza 4
Day 56: pizza 3
Day 57: pizza 5
Day 58: pizza 4
Day 59: pizza 3
Day 60: pizza 5
Day 61: pizza 4
Day 62: pizza 3
Day 63: pizza 5
Day 64: pizza 4
Day 65: pizza 3
Day 66: pizza 5
Day 67: pizza 4
Day 68: pizza 3
Day 69: pizza 5
Day 70: pizza 4
Day 71: pizza 3
Day 72: pizza 5
Day 73: pizza 4
Day 74: pizza 3
Day 75: pizza 5
Day 76: pizza 4
Day 77: pizza 3
Day 78: pizza 5
Day 79: pizza 4
Day 80: pizza 3
Day 81: pizza 5
Day 82: pizza 4
Day 83: pizza 3
Day 84: pizza 5
Day 85: pizza 4
Day 86: pizza 3
Day 87: pizza 5
Day 88: pizza 4
Day 89: pizza 3
Day 90: pizza 5
Day 91: pizza 4
Day 92: pizza 3
Day 93: pizza 5
Day 94: pizza 4
Day 95: pizza 3
Day 96: pizza 5
Day 97: pizza 4
Day 98: pizza 3
Day 99: pizza 5
Day 100: pizza 4
Day 101: pizza 3
Day 102: pizza 5
Day 103: pizza 4
Day 104: pizza 3
Day 105: pizza 5
Day 106: pizza 4
Day 107: pizza 3
Day 108: pizza 5
Day 109: pizza 4
Day 110: pizza 3
Day 111: pizza 5
Day 112: pizza 4
Day 113: pizza 3
Day 114: pizza 5
Day 115: pizza 4
Day 116: pizza 3
Day 117: pizza 5
Day 118: pizza 4
Day 119: pizza 3
Day 120: pizza 5
Day 121: pizza 4
Day 122: pizza 3
Day 123: pizza 5
Day 124: pizza 4
Day 125: pizza 3
Day 126: pizza 5
Day 127: pizza 4
Day 128: pizza 3
Day 129: pizza 5
Day 130: pizza 4
Day 131: pizza 3
Day 132: pizza 5
Day 133: pizza 4
Day 134: pizza 3
Day 135: pizza 5
Day 136: pizza 4
Day 137: pizza 3
Day 138: pizza 5
Day 139: pizza 4
Day 140: pizza 3
Day 141: pizza 5
Day 142: pizza 4
Day 143: pizza 3
Day 144: pizza 5
Day 145: pizza 4
Day 146: pizza 3
Day 147: pizza 5
Day 148: pizza 4
Day 149: pizza 3
Day 150: pizza 5
Day 151: pizza 4
Day 152: pizza 3
Day 153: pizza 5
Day 154: pizza 4
Day 155: pizza 3
Day 156: pizza 5
Day 157: pizza 4
Day 158: pizza 3
Day 159: pizza 5
Day 160: pizza 4
Day 161: pizza 3
Day 162: pizza 5
Day 163: pizza 4
Day 164: pizza 3
Day 165: pizza 5
Day 166: pizza 4
Day 167: pizza 3
Day 168: pizza 5
Day 169: pizza 4
Day 170: pizza 3
Day 171: pizza 5
Day 172: pizza 4
Day 173: pizza 3
Day 174: pizza 5
Day 175: pizza 4
Day 176: pizza 3
Day 177: pizza 5
Day 178: pizza 4
Day 179: pizza 3
Day 180: pizza 5
Day 181: pizza 4
Day 182: pizza 3
Day 183: pizza 5
Day 184: pizza 4
Day 185: pizza 3
Day 186: pizza 5
Day 187: pizza 4
Day 188: pizza 3
Day 189: pizza 5
Day 190: pizza 4
Day 191: pizza 3
Day 192: pizza 5
Day 193: pizza 4
Day 194: pizza 3
Day 195: pizza 5
Day 196: pizza 4
Day 197: pizza 3
Day 198: pizza 5
Day 199: pizza 4
Day 200: pizza 3
Day 201: pizza 5
Day 202: pizza 4
Day 203: pizza 3
Day 204: pizza 5
Day 205: pizza 4
Day 206: pizza 3
Day 207: pizza 5
Day 208: pizza 4
Day 209: pizza 3
Day 210: pizza 5
Day 211: pizza 4
Day 212: pizza 3
Day 213: pizza 5
Day 214: pizza 4
Day 215: pizza 3
Day 216: pizza 5
Day 217: pizza 4
Day 218: pizza 3
Day 219: pizza 5
Day 220: pizza 4
Day 221: pizza 3
Day 222: pizza 5
Day 223: pizza 4
Day 224: pizza 3
Day 225: pizza 5
Day 226: pizza 4
Day 227: pizza 3
Day 228: pizza 5
Day 229: pizza 4
Day 230: pizza 3
Day 231: pizza 5
Day 232: pizza 4
Day 233: pizza 3
Day 234: pizza 5
Day 235: pizza 4
Day 236: pizza 3
Day 237: pizza 5
Day 238: pizza 4
Day 239: pizza 3
Day 240: pizza 5
Day 241: pizza 4
Day 242: pizza 3
Day 243: pizza 5
Day 244: pizza 4
Day 245: pizza 3
Day 246: pizza 5
Day 247: pizza 4
Day 248: pizza 3
Day 249: pizza 5
Day 250: pizza 4
Day 251: pizza 3
Day 252: pizza 5
Day 253: pizza 4
Day 254: pizza 3
Day 255: pizza 5
Day 256: pizza 4
Day 257: pizza 3
Day 258: pizza 5
Day 259: pizza 4
Day 260: pizza 3
Day 261: pizza 5
Day 262: pizza 4
Day 263: pizza 3
Day 264: pizza 5
Day 265: pizza 4
Day 266: pizza 3
Day 267: pizza 5
Day 268: pizza 4
Day 269: pizza 3
Day 270: pizza 5
Day 271: pizza 4
Day 272: pizza 3
Day 273: pizza 5
Day 274: pizza 4
Day 275: pizza 3
Day 276: pizza 5
Day 277: pizza 4
Day 278: pizza 3
Day 279: pizza 5
Day 280: pizza 4
Day 281: pizza 3
Day 282: pizza 5
Day 283: pizza 4
Day 284: pizza 3
Day 285: pizza 5
Day 286: pizza 4
Day 287: pizza 3
Day 288: pizza 5
Day 289: pizza 4
Day 290: pizza 3
Day 291: pizza 5
Day 292: pizza 4
Day 293: pizza 3
Day 294: pizza 5
Day 295: pizza 4
Day 296: pizza 3
Day 297: pizza 5
Day 298: pizza 4
Day 299: pizza 3
Day 300: pizza 5
Day 301: pizza 4
Day 302: pizza 3
Day 303: pizza 5
Day 304: pizza 4
Day 305: pizza 3
Day 306: pizza 5
Day 307: pizza 4
Day 308: pizza 3
Day 309: pizza 5
Day 310: pizza 4
Day 311: pizza 3
Day 312: pizza 5
Day 313: pizza 4
Day 314: pizza 3
Day 315: pizza 5
Day 316: pizza 4
Day 317: pizza 3
Day 318: pizza 5
Day 319: pizza 4
Day 320: pizza 3
Day 321: pizza 5
Day 322: pizza 4
Day 323: pizza 3
Day 324: pizza 5
Day 325: pizza 4
Day 326: pizza 3
Day 327: pizza 5
Day 328: pizza 4
Day 329: pizza 3
Day 330: pizza 5
Day 331: pizza 4
Day 332: pizza 3
Day 333: pizza 5
Day 334: pizza 4
Day 335: pizza 3
Day 336: pizza 5
Day 337: pizza 4
Day 338: pizza 3
Day 339: pizza 5
Day 340: pizza 4
Day 341: pizza 3
Day 342: pizza 5
Day 343: pizza 4
Day 344: pizza 3
Day 345: pizza 5
Day 346: pizza 4
Day 347: pizza 3
Day 348: pizza 5
Day 349: pizza 4
Day 350: pizza 3
Day 351: pizza 5
Day 352: pizza 4
Day 353: pizza 3
Day 354: pizza 5
Day 355: pizza 4
Day 356: pizza 3
Day 357: pizza 5
Day 358: pizza 4
Day 359: pizza 3
Day 360: pizza 5
Day 361: pizza 4
Day 362: pizza 3
Day 363: any pizza
Day 364: any pizza

 */