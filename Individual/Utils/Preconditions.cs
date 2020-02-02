using System;
using System.Collections;

namespace Individual.Utils
{
	public static class Preconditions
	{
		public static void CheckNotNull(object reference) {
			CheckNotNull(reference, null);
		}

		public static void CheckNotNull(object reference, string message) {
			if (reference == null) {
				throw new NullReferenceException(message ?? "object reference is null");
			}
		}

		public static void CheckNotEmpty(string str) {
			CheckNotEmpty(str, null);
		}

		public static void CheckNotEmpty(ICollection collection) {
			CheckNotNull(collection);
			CheckArgument(collection.Count > 0);
		}

		public static void CheckNotEmpty(string str, string message) {
			if (string.IsNullOrEmpty(str)) {
				throw new ArgumentException(message ?? "string is empty");
			}
		}

		public static void CheckArgument(bool condition) {
			CheckArgument(condition, null);
		}

		public static void CheckArgument(bool condition, string message) {
			if (!condition) {
				throw new ArgumentException(message ?? "Invalid argument value");
			}
		}

		public static void CheckIndex(int index, int length) {
			CheckIndex(index, length, null);
		}

		public static void CheckIndex(int index, int length, string message) {
			if (index < 0 || index >= length) {
				throw new IndexOutOfRangeException(message ?? "Index " + index + " is out of range [0, " + length + ")");
			}
		}

		public static void CheckIndexRange(int rangeOffset, int rangeLength, int length) {
			CheckIndexRange(rangeOffset, rangeLength, length, null);
		}

		public static void CheckIndexRange(int rangeOffset, int rangeLength, int length, string message) {
			if (rangeOffset < 0 || rangeLength < 0 || rangeOffset + rangeLength > length) {
				throw new IndexOutOfRangeException(message ?? "Interval [" + rangeOffset + ", " + (rangeOffset + rangeLength)
				                                   + ") is out of range [0, " + length + ")");
			}
		}
	}
}