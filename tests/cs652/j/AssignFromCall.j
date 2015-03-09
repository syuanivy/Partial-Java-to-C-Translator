class T {
    float f() { return 3.14; }
}

T t;
t = new T();
float q;
q = t.f();
printf("%f\n", q);
