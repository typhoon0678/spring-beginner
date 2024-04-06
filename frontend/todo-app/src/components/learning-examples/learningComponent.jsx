import FirstComponent from "./FirstComponent";
import SecondComponent from "./SecondComponent";
import ThirdComponent from "./ThirdComponent";

export default function LearningComponent() {
  return (
    <div className="App">
      My Todo Application
      <FirstComponent />
      <SecondComponent />
      <ThirdComponent />
    </div>
  );
}
