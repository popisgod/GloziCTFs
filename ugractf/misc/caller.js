



const wasmInstance =
      new WebAssembly.Instance('./flag.__', {});
const { addTwo } = wasmInstance.exports;
for (let i = 0; i < 10; i++) {
  console.log(addTwo(i, i));
}
